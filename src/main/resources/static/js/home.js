function ready(callback) {
    if (document.readyState != 'loading') callback();
    else if(document.addEventListener) document.addEventListener('DOMContentLoaded',callback);
    else document.attachEvent('onreadystatechange', function () {
           if (document.readyState == 'complete') callback();
        });
}

ready(function () {

    init();

    function init() {
        // Set the scene size.
        const WIDTH = 800;
        const HEIGHT = 600;

// Set some camera attributes.
        const VIEW_ANGLE = 45;
        const ASPECT = WIDTH / HEIGHT;
        const NEAR = 0.1;
        const FAR = 10000;

// Get the DOM element to attach to
        const container =
            document.querySelector('#container');

// Create a WebGL renderer, camera
// and a scene
        const renderer = new THREE.WebGLRenderer({alpha:true});
        const camera =
            new THREE.PerspectiveCamera(
                VIEW_ANGLE,
                ASPECT,
                NEAR,
                FAR
            );

        const scene = new THREE.Scene();

// Add the camera to the scene.
        scene.add(camera);

// Start the renderer.
        renderer.setSize(WIDTH, HEIGHT);


        // create the sphere's material
        const sphereMaterial =
            new THREE.MeshLambertMaterial(
                {
                    color: 0xCC0000
                });


        //Defines the tetrahedron properties
        const radius = 82.0;
        const details = 0;
// Create a new mesh with
// sphere geometry - we will cover
// the sphereMaterial next!
        const sphere = new THREE.Mesh(

            new THREE.TetrahedronGeometry(
                radius,
                details),

            sphereMaterial);

// Move the Sphere back in Z so we
// can see it.
        sphere.position.z = -300;

// Finally, add the sphere to the scene.
        scene.add(sphere);

        // create a point light
        const pointLight =
            new THREE.PointLight(0xFFFFFF);

// set its position
        pointLight.position.x = 10;
        pointLight.position.y = 50;
        pointLight.position.z = 130;

// add to the scene
        scene.add(pointLight);

        // Attach the renderer-supplied
// DOM element.
        // Draw!
        renderer.render(scene, camera);
        container.appendChild(renderer.domElement);

        function update () {
            // Draw!
            renderer.render(scene, camera);

            // Schedule the next frame.
            requestAnimationFrame(update);
        }

// Schedule the first frame.
        requestAnimationFrame(update);
    }

});
