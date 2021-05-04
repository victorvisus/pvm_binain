CREATE TABLE IF NOT EXISTS `binain_mvp`.`tipo_usuarios` (
  `idTipoUsr` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoUsr`));
  
  CREATE TABLE IF NOT EXISTS `binain_mvp`.`usuarios` (
  `idUsuario` INT NOT NULL,
  `nickName` VARCHAR(30) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `last_session` DATETIME NULL DEFAULT '0000-00-00 00:00:00',
  `idTipoUsr` INT NULL DEFAULT NULL COMMENT '\'sala | artista\'\nALTER TABLE usuarios ADD CONSTRAINT tipoUser_VAL CHECK (sexo IN (\'Sala\',\'Artista\'));',
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `nickName_UNIQUE` (`nickName` ASC) INVISIBLE,
  INDEX `idTipoUsr_idx` (`idTipoUsr` ASC) VISIBLE,
  CONSTRAINT `idTipoUsr_usuarios`
    FOREIGN KEY (`idTipoUsr`)
    REFERENCES `binain_mvp`.`tipo_usuarios` (`idTipoUsr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE IF NOT EXISTS `binain_mvp`.`datospersonales` (
  `idDatosPersonales` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellidoUno` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `localidad` VARCHAR(45) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idDatosPersonales`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `idUsuarioDatos_datosPers`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `binain_mvp`.`usuarios` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
CREATE TABLE IF NOT EXISTS `binain_mvp`.`artistas` (
  `idArtista` INT NOT NULL AUTO_INCREMENT,
  `nombreArtistico` VARCHAR(45) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idArtista`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) VISIBLE,
  UNIQUE INDEX `idArtista_UNIQUE` (`idArtista` ASC) VISIBLE,
  CONSTRAINT `idUsuarioArtista_artistas`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `binain_mvp`.`usuarios` (`idUsuario`));
    
CREATE TABLE IF NOT EXISTS `binain_mvp`.`salas` (
  `idSala` INT NOT NULL AUTO_INCREMENT,
  `NombreSala` VARCHAR(45) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idSala`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) INVISIBLE,
  UNIQUE INDEX `idSala_UNIQUE` (`idSala` ASC) VISIBLE,
  CONSTRAINT `idUsuarioSala_salas`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `binain_mvp`.`usuarios` (`idUsuario`));
  
CREATE TABLE IF NOT EXISTS `binain_mvp`.`eventos` (
  `idEventos` INT NOT NULL AUTO_INCREMENT,
  `idArtista` INT NOT NULL,
  `idSala` INT NOT NULL,
  `Fecha_evento` DATE NOT NULL,
  `Ciudad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEventos`),
  INDEX `idArtista_idx` (`idArtista` ASC) VISIBLE,
  INDEX `idSala_idx` (`idSala` ASC) VISIBLE,
  CONSTRAINT `idArtistaEvento_eventos`
    FOREIGN KEY (`idArtista`)
    REFERENCES `binain_mvp`.`artistas` (`idArtista`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idSalaEvento_eventos`
    FOREIGN KEY (`idSala`)
    REFERENCES `binain_mvp`.`salas` (`idSala`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
INSERT INTO `binain_mvp`.`tipo_usuarios`(nombre) VALUES ('Sala');
INSERT INTO `binain_mvp`.`tipo_usuarios`(nombre) VALUES ('Artista');