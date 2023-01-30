--CATEGORIA
insert into categoria (descripcion) values('Electrodomestico');
insert into categoria (descripcion) values('Escritorio');
insert into categoria (descripcion) values('Computacion');

--PRODUCTO
insert into producto (color, marca, producto_nombre,observaciones, tipo) values
('Red & Black', 'Racer', 'Silla Gamer', 'Special Edition', 'Gamer'),
('Blanca', 'Gafa', 'Heladera', 'Special Edition', 'Acero inoxidable'),
('Plata', 'Asus', 'Notebook ASUS x515EA', 'Special Edition', '');


--USUARIOS
insert into usuario(nombre_de_usuario) values
('Vendedor_A'),
('Vendedor_B');

insert into seguidor (nombre_de_seguidor) values
('User_A'),
('User_B'),
('User_C'),
('User_D'),
('User_E');

--
insert into usuario_seguidor (usuario_id, seguidor_id) values
(1,1),
(1,2),
(1,3),
(2,4),
(2,5),
(1,4);


--
----Armado de publicaciones
insert into publicacion (descuento, en_promocion, fecha_alta, precio, precio_descuento, categoria_id, producto_id,usuario_id) values
(20,false,'29/1/2023',35000,35000,2,1,1),
(20,true,'29/1/2023',179000,134250,3,3,1),
(20,true,'29/1/2023',179000,134250,3,3,2);

