CREATE SEQUENCE id_participante_id_seq;
CREATE TABLE public.participante (
    id_participante INT NOT NULL DEFAULT NEXTVAL('id_participante_id_seq'),    
    nome VARCHAR(100) NOT NULL,
    cpf NUMERIC(11) NOT NULL,
    rg VARCHAR(20),
    data_nascimento DATE,
    cep INT,
    endereco VARCHAR(60),
    numero VARCHAR(60),
    complemento VARCHAR(60),
    estado VARCHAR(60),
    cidade VARCHAR(60),
    bairro VARCHAR(60),
    email VARCHAR(60),
    telefone VARCHAR(60),
    valor_total FLOAT,	
    CONSTRAINT participante_pkey PRIMARY KEY (id_participante)    
);
ALTER SEQUENCE id_participante_id_seq OWNED BY participante.id_participante;

CREATE SEQUENCE id_curso_id_seq;
CREATE TABLE public.curso (
    id_curso INT NOT NULL DEFAULT NEXTVAL('id_curso_id_seq'),    
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(500),
    vagas INT,
    valor FLOAT,
    data_curso DATE,
    hora_inicio VARCHAR(6),
    hora_fim VARCHAR(6),
    CONSTRAINT curso_pkey PRIMARY KEY (id_curso)    
);
ALTER SEQUENCE id_curso_id_seq OWNED BY curso.id_curso;

CREATE TABLE public.curso_participante (
    id_participante INT NOT NULL,    
    id_curso INT NOT NULL,
    CONSTRAINT curso_participante_pkey PRIMARY KEY (id_participante,id_curso),		
    CONSTRAINT participante_fkey FOREIGN KEY (id_participante) REFERENCES participante(id_participante),
    CONSTRAINT curso_fkey FOREIGN KEY (id_curso) REFERENCES curso(id_curso)    
);