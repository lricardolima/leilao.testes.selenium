INSERT INTO `users` (`user_id`, `email`, `enabled`, `username`, `role`, `password`) VALUES
(1,	'fulano@gmail.com',	1,	'fulano',	'USER',	'$2a$10$8MeF8YTUTv22DVthkhOs3.WGT4W1Wp1xRXcRxTM12MgDzRviDpw7i'),
(2,	'ciclano@gmail.com',	1,	'ciclano',	'USER',	'$2a$10$8MeF8YTUTv22DVthkhOs3.WGT4W1Wp1xRXcRxTM12MgDzRviDpw7i'),
(3,	'beltrano@gmail.com',	1,	'beltrano',	'USER',	'$2a$10$8MeF8YTUTv22DVthkhOs3.WGT4W1Wp1xRXcRxTM12MgDzRviDpw7i'),
(4,	'beltran@gmail.com',	1,	'ricardo',	'USER',	'$2a$10$8MeF8YTUTv22DVthkhOs3.WGT4W1Wp1xRXcRxTM12MgDzRviDpw7i');

INSERT INTO `leilao` (`id`, `data_abertura`, `nome`, `valor_inicial`, `usuario_user_id`) VALUES
(1,	'2020-08-03',	'Tablet Xpto 3',	5.00,	1),
(2,	'2020-08-03',	'Computador Z3',	500.00,	3),
(3,	'2022-05-19',	'Poco X3 Pro',	1500.00,	4);

INSERT INTO `lance` (`id`, `data`, `valor`, `leilao_id`, `usuario_user_id`) VALUES

