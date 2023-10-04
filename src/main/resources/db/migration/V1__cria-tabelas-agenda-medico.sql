create table tb_agenda (
    data_consulta timestamp(6) not null,
    id bigserial not null,
    medico_id bigint,
    fim varchar(255) not null check (fim in ('H_8_00','H_9_00','H_10_00','H_11_00','H_12_00','H_13_00','H_14_00','H_15_00','H_16_00','H_17_00')),
    inicio varchar(255) not null check (inicio in ('H_8_00','H_9_00','H_10_00','H_11_00','H_12_00','H_13_00','H_14_00','H_15_00','H_16_00','H_17_00')),
    paciente_nome varchar(255) not null,
    tipo_consulta varchar(255) not null,
    primary key (id)
);

create table tb_medico (
    is_active boolean not null,
    id bigserial not null,
    especialidade varchar(255) check (especialidade in ('ClinicoGeral','Pediatra')),
    nome varchar(255) not null,
    primary key (id)
);

create table tb_medico_lista_de_horario (
    lista_de_horario_id bigint not null unique,
    medico_id bigint not null
);

alter table if exists tb_agenda
   add constraint FKly5q1lxty4t3huvr7sqlcued1
   foreign key (medico_id)
   references tb_medico;

alter table if exists tb_medico_lista_de_horario
   add constraint FKql2j1tv57qys2vuumcsxkqsfx
   foreign key (lista_de_horario_id)
   references tb_agenda;

alter table if exists tb_medico_lista_de_horario
   add constraint FK45fe6rf0e60adhc9bvrx3125i
   foreign key (medico_id)
   references tb_medico;