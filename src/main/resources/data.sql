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
('User_A'),
('User_B'),
('User_C'),
('User_D'),
('User_E'),
('Vendedor_A');

insert into vendedor (id) values
(6);

insert into comprador(id) values
(1),
(2),
(3),
(4),
(5);

--
insert into vendedor_comprador (vendedor_id, comprador_id) values
(6,1),
(6,2),
(6,3);

--
----Armado de publicaciones
insert into publicacion (descuento, en_promocion, fecha_alta, precio, precio_descuento, categoria_id, producto_id,vendedor_id) values
(20,false,'29/1/2023',35000,35000,2,1,6),
(20,true,'29/1/2023',179000,134250,3,3,6),
(20,true,'29/1/2023',179000,134250,3,3,6);

