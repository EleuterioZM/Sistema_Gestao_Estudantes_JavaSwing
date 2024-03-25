-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28-Fev-2024 às 13:58
-- Versão do servidor: 10.4.28-MariaDB
-- versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `engsoftware`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaliacao`
--

CREATE TABLE `avaliacao` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `peso` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `avaliacao`
--

INSERT INTO `avaliacao` (`id`, `descricao`, `peso`) VALUES
(1, 'Prova 1', 0.30),
(2, 'Prova 2', 0.40),
(3, 'Trabalho Prático', 0.30);

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaliacao_disciplina`
--

CREATE TABLE `avaliacao_disciplina` (
  `id_avaliacao` int(11) NOT NULL,
  `id_disciplina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `avaliacao_disciplina`
--

INSERT INTO `avaliacao_disciplina` (`id_avaliacao`, `id_disciplina`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`id`, `nome`) VALUES
(1, 'Ciência da Computação'),
(2, 'Engenharia Civil'),
(3, 'Administração');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `chs` int(11) DEFAULT NULL,
  `credito` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`id`, `nome`, `chs`, `credito`) VALUES
(1, 'Matemática', 60, 6),
(2, 'Física', 60, 6),
(3, 'Programação', 80, 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `estudante`
--

CREATE TABLE `estudante` (
  `nr_matricula` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `apelido` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `contacto` varchar(20) DEFAULT NULL,
  `id_turma` int(11) DEFAULT NULL,
  `id_curso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `estudante`
--

INSERT INTO `estudante` (`nr_matricula`, `nome`, `apelido`, `endereco`, `contacto`, `id_turma`, `id_curso`) VALUES
(1001, 'João', 'Silva', 'Rua A, 123', '123456789', 1, 1),
(1002, 'Maria', 'Santos', 'Rua B, 456', '987654321', 1, 2),
(1003, 'Pedro', 'Oliveira', 'Rua C, 789', '456123789', 2, 3),
(1004, 'Ana', 'Pereira', 'Rua D, 789', '789456123', 2, 1),
(1005, 'Luísa', 'Martins', 'Rua E, 789', '159357456', 3, 2),
(1006, 'Carlos', 'Souza', 'Rua F, 789', '456789123', 1, 1),
(1007, 'Fernanda', 'Lima', 'Rua G, 789', '789123456', 2, 2),
(1008, 'Gabriel', 'Ferreira', 'Rua H, 789', '321654987', 3, 3),
(1009, 'Mariana', 'Gomes', 'Rua I, 789', '654789321', 1, 2),
(1010, 'Rafael', 'Almeida', 'Rua J, 789', '987321654', 3, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `realiza`
--

CREATE TABLE `realiza` (
  `id_estudante` int(11) NOT NULL,
  `id_avaliacao` int(11) NOT NULL,
  `nota` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `realiza`
--

INSERT INTO `realiza` (`id_estudante`, `id_avaliacao`, `nota`) VALUES
(1001, 1, 8.50),
(1001, 2, 7.80),
(1002, 1, 6.90),
(1002, 2, 9.20),
(1003, 1, 5.40),
(1003, 2, 6.70),
(1004, 1, 9.00),
(1004, 2, 8.60),
(1005, 1, 7.20),
(1005, 2, 8.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`id`, `descricao`) VALUES
(1, 'Turma de Matemática'),
(2, 'Turma de Física'),
(3, 'Turma de Programação');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `avaliacao_disciplina`
--
ALTER TABLE `avaliacao_disciplina`
  ADD PRIMARY KEY (`id_avaliacao`,`id_disciplina`),
  ADD KEY `id_disciplina` (`id_disciplina`);

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `estudante`
--
ALTER TABLE `estudante`
  ADD PRIMARY KEY (`nr_matricula`),
  ADD KEY `id_turma` (`id_turma`),
  ADD KEY `fk_curso` (`id_curso`);

--
-- Índices para tabela `realiza`
--
ALTER TABLE `realiza`
  ADD PRIMARY KEY (`id_estudante`,`id_avaliacao`),
  ADD KEY `id_avaliacao` (`id_avaliacao`);

--
-- Índices para tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`id`);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `avaliacao_disciplina`
--
ALTER TABLE `avaliacao_disciplina`
  ADD CONSTRAINT `avaliacao_disciplina_ibfk_1` FOREIGN KEY (`id_avaliacao`) REFERENCES `avaliacao` (`id`),
  ADD CONSTRAINT `avaliacao_disciplina_ibfk_2` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplina` (`id`);

--
-- Limitadores para a tabela `estudante`
--
ALTER TABLE `estudante`
  ADD CONSTRAINT `estudante_ibfk_1` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id`),
  ADD CONSTRAINT `fk_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`);

--
-- Limitadores para a tabela `realiza`
--
ALTER TABLE `realiza`
  ADD CONSTRAINT `realiza_ibfk_1` FOREIGN KEY (`id_estudante`) REFERENCES `estudante` (`nr_matricula`),
  ADD CONSTRAINT `realiza_ibfk_2` FOREIGN KEY (`id_avaliacao`) REFERENCES `avaliacao` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
