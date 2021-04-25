-- TABLA usuarios
CREATE TABLE IF NOT EXISTS `binain_mvp`.`usuarios` (
  `idUsuario` INT NOT NULL,
  `nickName` VARCHAR(30) NOT NULL,
  `contrasenia` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `idTipoUsuario` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `nickName_UNIQUE` (`nickName` ASC) VISIBLE,
  UNIQUE INDEX `idTipoUsuario_UNIQUE` (`idTipoUsuario` ASC) VISIBLE);

-- TABLA datosPersonales
CREATE TABLE IF NOT EXISTS `binain_mvp`.`datosPersonales` (
  `nombre` VARCHAR(45) NOT NULL,
  `apellidoUno` VARCHAR(45) NOT NULL,
  `apellidoDos` VARCHAR(45) NULL,
  `numeroSeguridadSocial` VARCHAR(45) NULL,
  `DNI` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `idUsuario` INT NOT NULL,
  UNIQUE INDEX `numeroSeguridadSocial_UNIQUE` (`numeroSeguridadSocial` ASC) VISIBLE,
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC) VISIBLE,
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) VISIBLE,
  PRIMARY KEY (`DNI`),
  CONSTRAINT `idUsuarioDatos`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `binain_mvp`.`usuarios` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

-- TABLA salas
CREATE TABLE IF NOT EXISTS `binain_mvp`.`salas` (
  `NombreSala` VARCHAR(45) NOT NULL,
  `Localidad` VARCHAR(45) NOT NULL,
  `idUsuario` INT NOT NULL,
  `idSala` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idSala`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) INVISIBLE,
  UNIQUE INDEX `idSala_UNIQUE` (`idSala` ASC) VISIBLE,
  CONSTRAINT `idUsuarioSala`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `binain_mvp`.`usuarios` (`idUsuario`));

-- TABLA artistas
CREATE TABLE IF NOT EXISTS `binain_mvp`.`artistas` (
  `idArtista` INT NOT NULL AUTO_INCREMENT,
  `Localidad` VARCHAR(45) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idArtista`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC) VISIBLE,
  UNIQUE INDEX `idArtista_UNIQUE` (`idArtista` ASC) VISIBLE,
  CONSTRAINT `idUsuarioArtista`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `binain_mvp`.`usuarios` (`idUsuario`));

-- TABLA estilos_musica
CREATE TABLE IF NOT EXISTS `binain_mvp`.`estilos_musica` (
  `idEstilo` INT NOT NULL,
  `nombreEstilo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstilo`));
  
-- TABLA estilos_usuarios
CREATE TABLE IF NOT EXISTS `binain_mvp`.`estilos_usuarios` (
  `idEstilo` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idEstilo`, `idUsuario`),
  INDEX `idUsuario_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `idEstiloUsuario`
    FOREIGN KEY (`idEstilo`)
    REFERENCES `binain_mvp`.`estilos_musica` (`idEstilo`),
  CONSTRAINT `idUsuarioEstilo`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `binain_mvp`.`usuarios` (`idUsuario`));

-- TABLA eventos
CREATE TABLE IF NOT EXISTS `binain_mvp`.`eventos` (
  `idEventos` INT NOT NULL AUTO_INCREMENT,
  `idArtista` INT NOT NULL,
  `idSala` INT NOT NULL,
  `Fecha_evento` DATE NOT NULL,
  PRIMARY KEY (`idEventos`),
  INDEX `idArtista_idx` (`idArtista` ASC) VISIBLE,
  INDEX `idSala_idx` (`idSala` ASC) VISIBLE,
  CONSTRAINT `idArtistaEvento`
    FOREIGN KEY (`idArtista`)
    REFERENCES `binain_mvp`.`artistas` (`idArtista`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idSalaEvento`
    FOREIGN KEY (`idSala`)
    REFERENCES `binain_mvp`.`salas` (`idSala`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);