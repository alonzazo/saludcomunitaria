
class CarrouselFullScreenSection extends HTMLElement {

    constructor(){
        super();
        const root = this.attachShadow({'mode':'open'});

        const carrouselTemplate = document.createElement('template');
        carrouselTemplate.innerHTML = `
        <style>
            :host {
                display: flex;
            }

            #left-control {
                width: 0px;
                position: relative;
                left: 20px;
                top: 50vh;
            }

                #left-control svg {
                    width: 50px;
                    transition: width .25s ease;
                }

                #left-control svg:hover {
                    width: 55px;
                    cursor: pointer;
                }

            #images-container {

            }

            #right-control {
                width: 0px;
                position: relative;
                left: -90px;
                top: 50vh;
            }

                #right-control svg {
                    width: 50px;
                    transition: width .25s ease;
                }

                #right-control svg:hover {
                    cursor: pointer;
                    width: 55px;
                }

            p { size: 23px;}
        </style>
        <div id="left-control">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
        viewBox="0 0 492 492" style="enable-background:new 0 0 492 492;" xml:space="preserve">
            <g>
                <g>
                    <path fill="#FFFFFF" d="M198.608,246.104L382.664,62.04c5.068-5.056,7.856-11.816,7.856-19.024c0-7.212-2.788-13.968-7.856-19.032l-16.128-16.12
                    C361.476,2.792,354.712,0,347.504,0s-13.964,2.792-19.028,7.864L109.328,227.008c-5.084,5.08-7.868,11.868-7.848,19.084
                    c-0.02,7.248,2.76,14.028,7.848,19.112l218.944,218.932c5.064,5.072,11.82,7.864,19.032,7.864c7.208,0,13.964-2.792,19.032-7.864
                    l16.124-16.12c10.492-10.492,10.492-27.572,0-38.06L198.608,246.104z"/>
                </g>
            </g>
        </svg>
        </div>
        <div id="images-container">
        <slot></slot>
        </div>
        <div id="right-control">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
        viewBox="0 0 492 492" style="enable-background:new 0 0 492 492; transform: scaleX(-1);" xml:space="preserve">
            <g>
                <g>
                    <path fill="#FFFFFF" d="M198.608,246.104L382.664,62.04c5.068-5.056,7.856-11.816,7.856-19.024c0-7.212-2.788-13.968-7.856-19.032l-16.128-16.12
                    C361.476,2.792,354.712,0,347.504,0s-13.964,2.792-19.028,7.864L109.328,227.008c-5.084,5.08-7.868,11.868-7.848,19.084
                    c-0.02,7.248,2.76,14.028,7.848,19.112l218.944,218.932c5.064,5.072,11.82,7.864,19.032,7.864c7.208,0,13.964-2.792,19.032-7.864
                    l16.124-16.12c10.492-10.492,10.492-27.572,0-38.06L198.608,246.104z"/>
                </g>
            </g>
        </svg>
        </div>
        `;
        this.shadowRoot.appendChild(carrouselTemplate.content.cloneNode(true));

        this.imagesCollection = this.children;

        for (let i = 0; i < this.imagesCollection.length; i++){
            this.imagesCollection[i].style.display = 'none';
        }

        this.currentImage = this.imagesCollection.item(0);
        this.currentImage.style.display = 'flex';

        let leftControl = this.shadowRoot.querySelector('#left-control').firstElementChild;
        let rightControl = this.shadowRoot.querySelector('#right-control').firstElementChild;

        leftControl.addEventListener('click', this.goBefore.bind(this));
        rightControl.addEventListener('click', this.goNext.bind(this));
    }

    goNext(event) {
        this.currentImage.style.display = 'none';
        if (this.currentImage.nextElementSibling != null){
            this.currentImage = this.currentImage.nextElementSibling;
        } else {
            this.currentImage = this.imagesCollection.item(0);
        }
        this.currentImage.style.display = 'flex';
    }

    goBefore(event){
        this.currentImage.style.display = 'none';
        if (this.currentImage.previousElementSibling != null){
            this.currentImage = this.currentImage.previousElementSibling;
        } else {
            this.currentImage = this.imagesCollection.item(this.imagesCollection.length - 1);
        }
        this.currentImage.style.display = 'flex';
    }

}

class ImageCarrouselElement extends HTMLElement {

    constructor(){
        super();
        const root = this.attachShadow({'mode': 'open'});

        const imageTemplate = document.createElement('template');
        imageTemplate.innerHTML = `
        <style>
            :host {
            display: flex;
            flex-direction: column;
            flex-flow: column-reverse;
            background: rgb(32,32,32);
            background-size: cover;
            height: 100vh;
            width: 100vw;
        }

        #titles-container {
            display: inline-flex;
            align-items: baseline;
            margin: 5px 48px 5px 48px; 
        }

        #title-link {
            text-decoration: none;
        }

        #title-link:hover {
            text-decoration: underline;
            text-decoration-color: white;
        }

        h1 {
            color: white;
            font-size: xx-large;
            text-decoration: none; 
            width: fit-content;
            text-shadow: 0px 0px 10px rgba(0,0,0,.75);
            line-height: normal;
        }
        
        h2 {
            font-size: x-small;
            color: rgba(128,128,128,1);
            width: fit-content;
            font-weight: 400;
        }

        p {
            color: white;
            font-size: normal;
            margin: 3px 30% 30px 48px;
        }

        #link {
            color: rgb(64,196,255);
            text-align: right;
            padding: 20px 96px 20px 48px;
            border-top-color: rgba(255, 255, 255, 0.25);
            border-top-width: 1px;
            border-top-style: solid;

            font-size: 14px;
            font-weight: 500;
            text-decoration: none;

            transition: background-color .5s ease, box-shadow .5s ease;
        }

        #link:hover {
            background-color: rgba(0,0,0,.9);
        }

        #grey-cortain {
            background: linear-gradient(rgba(0,0,0,0), rgba(0,0,0,0.75));
            width: 100%;
            height: 25vh;
            margin-top: -25vh;
        }
        </style>
        <div id="grey-cortain"></div>
        <a id = "link">LEER MÁS</a>
        <p id ="paragraph"><slot></slot></p>
        <div id="titles-container"><a id = "title-link"><h1 id="title"></h1></a><h2 id="little-title"></h2><div>
        `;

        root.appendChild(imageTemplate.content.cloneNode(true));
    }

    connectedCallback(){
        let imageUrl = this.getAttribute('img-src');
        this.style.backgroundImage = 'url(\'' + imageUrl +'\')';

        const titleElement = this.shadowRoot.querySelector('#title');
        titleElement.innerHTML = this.getAttribute('title');

        const littleTitleElement = this.shadowRoot.querySelector('#little-title');
        littleTitleElement.innerHTML = this.getAttribute('little-title');

        const linkElement = this.shadowRoot.querySelector('#link');
        const titleLinkElement = this.shadowRoot.querySelector('#title-link');
        let link = this.getAttribute('href');
        linkElement.href = link;
        titleLinkElement.href = link;
    }
}

customElements.define('image-carrousel-element', ImageCarrouselElement);
customElements.define('carrousel-full-screen-section',CarrouselFullScreenSection);