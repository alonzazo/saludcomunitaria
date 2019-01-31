/**************************DEFINICIÓN DE TABLA BLOG_ENTRY
//Responsabilidad: Almacenar las entradas de blog
/*********************************************************/
create table blog_entry (
  entry_id      int primary key auto_increment,     /*Se usa un id autoincrementar para llevarun conteo de las entradas*/
  useremail_fk  varchar(255),                         /*Se relaciona la entrada con el usuario que la creó*/
  creation_timestamp datetime not null,                        /*Se almacena la fecha de creación de la entrada*/
  broadcasting_date datetime not null,                    /*Se almacena la fecha de publicación de la entrada*/
  likes         int default 0,                        /*Cantidad de likes*/
  title_entry   varchar(255) not null,                /*Se almacena el título de la entrada*/
  abstract_entry  varchar(255),                       /*Se almacena un resumen de la entrada para desplegarlo en la pantalla de selección de entradas y en la noticias*/
  content_entry  varchar(2000),                       /*Se almacena el contenido*/
  news          binary not null,                               /*Se permite decidir si se mostará en la sección de noticias*/

  CONSTRAINT user_relation
  FOREIGN KEY blog_entry(useremail_fk) REFERENCES user(email)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
);

/**************************DEFINICIÓN DE TABLA BLOG_ENTRY_LIKES
//Responsabilidad: Almacenar los likes del cada entry del blog
/*********************************************************/
create table blog_entry_likes (
  entry_id int,                 #Se almacena el id del entry para relacionarlo con quien le dio me gusta
  useremail_fk varchar(255),    #Se almacena quien le dio me gusta para saber si ya alguien particular le dio me gusta

  #Se crean las relaciones
  constraint primary_key
  primary key (entry_id,useremail_fk),
  constraint entries_relation
  foreign key blog_entry_likes(entry_id) references blog_entry(entry_id)
    on delete cascade /* Si se elimina un blog_entry también se eliminan sus likes*/
    on update cascade,
  constraint user_likes_relation
  foreign key blog_entry_likes(useremail_fk) references user(email)
    on delete no action
    on update cascade
);

/**************************DEFINICIÓN DE TABLA BLOG_ENTRY_COMMENTS
//Responsabilidad: Almacenar los comentarios de cada entry del blog
/*********************************************************/
create table blog_entry_comments (
  entry_id                  int,
  authoremail_fk            varchar(255),
  datetime                  datetime,
  comment_id                int,
  responseTo_entry_id_fk    int null,
  responseTo_comment_id_fk  int null,
  content                   varchar(500),

  constraint comments_primary_key
  primary key (entry_id, comment_id),
  constraint entry_comment_relation
  foreign key blog_entry_comments(entry_id) references blog_entry(entry_id)
    on delete cascade
    on update cascade,
  constraint author_comment_relation
  foreign key blog_entry_comments(authoremail_fk) references user(email)
    on delete no action
    on update cascade,
  constraint responseTo_commments_relation
  foreign key blog_entry_comments(responseTo_entry_id_fk, responseTo_comment_id_fk) references blog_entry_comments(entry_id,comment_id)
    on delete cascade #Talvez se puede enciclar cuando se elimina un entry
    on update cascade
);

insert into blog_entry values (1,
                               'admin',
                               '2018-11-08',
                               '2018-11-08',
                               0,
                               'Drake, un pueblo feliz',
                               'En la peninsula de osa hay un pueblo muy lindo.',
                               'En este pueblo',false);


insert into blog_entry values (2,
                               'admin',
                               '2018-11-08',
                               '2018-11-08',
                               0,
                               'Caletas, Van van es un pillo',
                               'En la costa del litoral pacífico de nuestro país...',
                               'En este pueblo',false);

insert into blog_entry values (4,
                               'admin',
                               '2018-11-09',
                               '2018-11-09',
                               'TCU 675 Taller de Investigación en Salud Comunitaria en la Península de Osa',
                               'El TCU 675 busca dotar de herramientas y conocimientos a las poblaciones en temas como energía, saneamiento básico, agua potable, entre otros, con la finalidad de inculcar una cultura de autogestión comunitaria que mejore las condiciones de vida de los pobladores.',
                               'El Trabajo Comunal Universitario denominado Taller de Investigación en Salud Comunitaria en la Península de Osa tiene como objetivo principal el impulsar dinámicas culturales que promuevan una construcción colectiva de la autogestión comunitaria, en interacción con la población nativa y actores sociales en la zona de Bahía Drake, Península de Osa. Este proyecto forma parte de la Vicerrectoría de Acción Social de la Universidad de Costa Rica, y es coordinado por la docente e investigadora Milena Castro Mora de la Escuela de Estadística, en colaboración con otras instancias institucionales.
                               Mediante el trabajo comunitario se busca estrechar vínculos entre la academia y las poblaciones más vulnerables del país, visibilizando el aporte sustancial que se realiza desde la Universidad de Costa Rica en cuanto a la promoción, creación, y difusión de conocimiento. Por su parte, el TCU 675 busca generar un impacto positivo en las condiciones de vida de la población de Bahía Drake, a través de la capacitación y empoderamiento comunitario en temas como acceso a agua potable, manejo adecuado de desechos sólidos y líquidos, asesorías legales en materia de niñez y adolescencia, alternativas energéticas, evaluaciones ecológicas, entre otros. El trabajo es realizado de forma asociativa y comunitaria, promoviendo la participación activa de las personas del área en el mejoramiento de sus condiciones de vida, por medio de la dotación de herramientas e información puntual que sirva de insumo en la generación de soluciones y resultados concretos.',
                               true,
                               'images/backgrounds/diego27.jpeg');

insert into user value ('oscar.azofeifa.segura@gmail.com','Azofeifa','Oscar',)



