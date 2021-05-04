INSERT INTO usuarios(nickName, password, email, idTipoUsr) VALUES ("invitadoSala", "invitado", "sala@mail.com", 1);
INSERT INTO usuarios(nickName, password, email, idTipoUsr) VALUES ("invitadoArtista", "invitado", "artista@mail.com", 2);


INSERT INTO datospersonales(nombre, apellido, direccion, localidad, idUsuario) VALUES ("nombreInvitadoSala", "apeInvitado Sala", "dirInvitado Sala", "Zaragoza",
(SELECT idUsuario FROM usuarios WHERE nickName = "invitadoSala" AND email = "sala@mail.com")
);
INSERT INTO salas(nombreSala, idUsuario) VALUES ("nombreSala", (SELECT idUsuario FROM usuarios WHERE nickName = "invitadoSala" AND email = "sala@mail.com"));


INSERT INTO datospersonales(nombre, apellido, direccion, localidad, idUsuario) VALUES ("nombreInvitadoArtista", "apeInvitado Artista", "dirInvitado Artista", "Alcañiz",
(SELECT idUsuario FROM usuarios WHERE nickName = "invitadoArtista" AND email = "artista@mail.com")
);
INSERT INTO artistas(nombreArtistico, idUsuario) VALUES ("nombreArtista", 
(SELECT idUsuario FROM usuarios WHERE nickName = "invitadoArtista" AND email = "artista@mail.com")
);