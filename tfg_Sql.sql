create database GESTEMPRESARIALTFG;
use GESTEMPRESARIALTFG;

create table  tblDatos_Empresa(
idEmpresa integer primary KEY auto_increment,
CIF_Empresa char(9) NOT NULL,
nombre_empresa char(50) NOT NULL,
direccion_empresa char(50) NOT NULL,
Telefonoprov bigint NOT NULL,
e_mail char(50),
activoEmpresa bit);

CREATE TABLE IF NOT EXISTS tblFamilias (
  IdFamilia int NOT NULL AUTO_INCREMENT primary key,
  CodigoFamilia char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  familia char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  activo bit);

create table tblMateriales

(
idMaterial integer primary key auto_increment,
codigo_material char(5) NOT NULL,
descripcion char(50),
IdFamilia int UNIQUE NOT NULL,
activo bit,
CONSTRAINT FK_tblMateriales_tbFamilia FOREIGN KEY (IdFamilia) REFERENCES tblFamilias (idFamilia));
 


create table tblProveedores
(
idProveedor integer primary key auto_increment,
CIFprov char(9) NOT NULL,
nombreprov char(20) NOT NULL,
apellidosprov char(30) NOT NULL,
direccion char(50) NOT NULL,
Telefonoprov bigint NOT NULL,
e_mail char(50),
activoprov bit);

create table tblMaterialProveedor
(
IDpro integer not null,
IDmat integer not null,
fecha date NOT NULL,
unidades smallint NOT NULL,
importe_ud integer NOT NULL,
activo bit,
constraint PK_matprov primary key  (IDpro,IDmat, fecha),
constraint FK_TMP_prov foreign key (IDpro) references tblProveedores(idProveedor) ON UPDATE CASCADE,
constraint FK_TMP_Mat foreign key(IDmat) references tblMateriales(idMaterial) ON UPDATE CASCADE) ;



create table tblTrabajadores(
idTrabajador integer primary key auto_increment,
categoria varchar(50),
NIFtrab char(9) NOT NULL UNIQUE,
ID_Empresa INTEGER NOT NULL,
Fecha date NOT NULL,
usuario char(30),
contrasenya char(10),
nombretrab char(20) NOT NULL,
apellidostrab char(30) NOT NULL,
direcciontrab char(50) NOT NULL,
Telefonotrab bigint NOT NULL,
e_mailtrab char(50),
Fecha_inicio date NOT NULL,
fecha_fin date NOT NULL,
activotrab bit,
constraint FK_tblTrabajadores_CIFEMPRESA foreign key(ID_Empresa) references tblDatos_Empresa (idEmpresa) ON UPDATE CASCADE);

create table tblNominas(
idNominas integer primary key auto_increment,
NIF_trab char(9) NOT NULL,
fecha date NOT NULL,
enbruto integer not null,
gastosirpf integer,
prorrata bit,
primas integer,
/*Porcentaje de retencion*/
retencion float,
contingencias_Comunes float,
accidentes_trabajo_empresario float,
cuota_obrera_general float,
cuota_desempleo_trabajador float,
cuota_formacion_trabajador float,
FOGASA_empresario float,
desempleo_empresario float,
formacion_Empresario float,
total integer NOT NULL,

constraint FK_tblSueldos_NIF foreign key(Nif_trab) references tblTrabajadores(NIFtrab) ON UPDATE CASCADE);

create table tblClientes(
idCliente integer primary key not null auto_increment,
CIFNIFcli char(9) NOT NULL,
Fecha date NOT NULL,
nombrecli char(20) NOT NULL,
apellidoscli char(30) NOT NULL,
direccioncli varchar(50) NOT NULL,
Telefonocli bigint NOT NULL,
e_mailcli char(50),
activocli bit);

create table tblFacturas(
n_factura integer not null auto_increment primary key,
idCliente integer not null,
CIFNIF char(9) not null,
descripcion text,
cantidad int not null,
tipo char(10),
iva_aplicado tinyint default 21,
constraint FK_tblFacturas_NIF foreign key(idCliente) references tblClientes(idCliente) ON UPDATE CASCADE);

create table TblPresupuestos(
n_presupuesto integer not null auto_increment primary key,
idCliente integer not null,
CIFNIF char(15) not null,
descripcion text,
cantidad int not null,
tipo char(10),
iva_aplicado tinyint default 21,
constraint FK_tblPresupuestos_NIF foreign key(idCliente) references tblClientes(idCliente) ON UPDATE CASCADE);


create table tblPosiblesTrabajos(
idPosibleTrabajo integer primary key auto_increment,
codigo_tarea char(15) UNIQUE NOT NULL UNIQUE,
descripcion char(100) NOT NULL,
activoTrabajo bit,
importeud integer);


create table tblTrabajosRealizados(
cod_trabajo integer not null auto_increment primary key,
fecha_inicio timestamp(6) not null,
descripcion text,
n_factura integer not null unique,
cifnif_trabajador char(15) not null unique,
fecha_fin timestamp(6),
constraint FK_TTR_factura foreign key (n_factura) references tblFacturas(n_factura) ON UPDATE CASCADE,
constraint FK_TTR_NIFtrabajador foreign key (cifnif_trabajador) references tblTrabajadores(NIFtrab) ON UPDATE CASCADE);

create table tblTieneTrabajos(
	codigo_trabajo integer not null,
    codigo_tarea char(15) NOT NULL,
    importe_ud integer,
    constraint PK_tblTT primary key (codigo_trabajo, codigo_tarea),
    constraint FK_tblTTcod_trab foreign key (codigo_trabajo) references tblTrabajosRealizados (cod_trabajo) ON UPDATE CASCADE,
    constraint FK_tblTTcod_tarea foreign key (codigo_tarea) references tblPosiblesTrabajos (codigo_tarea) ON UPDATE CASCADE);

create table tMaterialUsado(
	cod_trabajo integer NOT NULL, 
     idMaterial integer NOT NULL,
    unidades smallint,
    uso_desgaste boolean,
    desgastado boolean,
    constraint PK_tblMatUsado primary key (cod_trabajo, idMaterial),
    constraint FK_tblMatUsed_cod_trabajo foreign key (cod_trabajo) references tblTrabajosrealizados (cod_trabajo) ON UPDATE CASCADE,
	constraint FK_tblMatUsed_cod_material foreign key (idMaterial) references tblMateriales (idMaterial) ON UPDATE CASCADE);

create table TrabajosEjecutados(
codigo_trabajo integer NOT NULL,
trabajador char(12) NOT NULL,
constraint PK_tblTrabEj primary key (codigo_trabajo, trabajador),
constraint FK_tblTrabEj_cod_trabajo foreign key (codigo_trabajo) references tblTrabajosrealizados (cod_trabajo) ON UPDATE CASCADE,
constraint FK_tblTrabEj_trabajador foreign key (trabajador) references tblTrabajadores (NIFtrab) ON UPDATE CASCADE

);


  
  
  CREATE TABLE IF NOT EXISTS tblStockMateriales (
  IdStock int NOT NULL AUTO_INCREMENT primary key,
  IdMaterial INT NOT NULL DEFAULT '0',
  CantidadReal int NOT NULL DEFAULT '0',
  CantidadPteRecibir  int NOT NULL DEFAULT '0',
  CantidadTotal int NOT NULL DEFAULT '0',

  
  CONSTRAINT FK_tblstockproductos_tblproductos FOREIGN KEY (IdMaterial) REFERENCES tblMateriales (idMaterial));