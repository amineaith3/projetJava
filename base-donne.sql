/*==============================================================*/
/* Nom de SGBD :  MySQL_sgbd_web project                        */
/* Date de création :  26/04/2024 18:02:04                      */
/*==============================================================*/


drop table if exists APPORTE;

drop table if exists BILLAN;

drop table if exists CONTIENT;

drop table if exists FICH;

drop table if exists INCLUS;

drop table if exists OBJECTIF;

drop table if exists PATIENT;

drop table if exists PRESCRIPTEUR;

drop table if exists PRESCRIPTION;

drop table if exists PROTOCOLE;

drop table if exists RDV;

drop table if exists SESSION;

drop table if exists TECHNIQUES;

/*==============================================================*/
/* Table : APPORTE                                              */
/*==============================================================*/
create table APPORTE
(
   ID_FICH              bigint not null,
   ID_OBJECTIF          bigint not null,
   primary key (ID_FICH, ID_OBJECTIF)
);

/*==============================================================*/
/* Table : BILLAN                                               */
/*==============================================================*/
create table BILLAN
(
   ID_BILAN             bigint not null AUTO_INCREMENT,
   ID_FICH              bigint not null,
   NOTE                 text,
   TYPE_BILAN           varchar(70),
   primary key (ID_BILAN)
);

/*==============================================================*/
/* Table : CONTIENT                                             */
/*==============================================================*/
create table CONTIENT
(
   ID_FICH              bigint not null,
   ID_PROTOCOLE         bigint not null,
   primary key (ID_FICH, ID_PROTOCOLE)
);

/*==============================================================*/
/* Table : FICH                                                 */
/*==============================================================*/
create table FICH
(
   ID_FICH              bigint not null AUTO_INCREMENT,
   ID_SESSION           bigint not null,
   FICHIERPATH          varchar(100),
   NOTE_FISHIER         text,
   primary key (ID_FICH)
);

/*==============================================================*/
/* Table : INCLUS                                               */
/*==============================================================*/
create table INCLUS
(
   ID_PROTOCOLE         bigint not null,
   ID_TECHNIQUE         bigint not null,
   primary key (ID_PROTOCOLE, ID_TECHNIQUE)
);

/*==============================================================*/
/* Table : OBJECTIF                                             */
/*==============================================================*/
create table OBJECTIF
(
   ID_OBJECTIF          bigint not null AUTO_INCREMENT,
   NOTES_OBJECTIF       text,
   primary key (ID_OBJECTIF)
);


/*==============================================================*/
/* Table : PATIENT                                              */
/*==============================================================*/
create table PATIENT
(
   ID_PATIENT           bigint not null AUTO_INCREMENT,
   CIN                  varchar(10),
   PRENOM               varchar(20),
   NOM                  varchar(20),
   TEL                  varchar(15),
   SEXE                 varchar(10),
   DATENAISSANCE        date,
   ADDRESS              text,
   NOTE                 text,
   MUTUELLE             varchar(20),
   primary key (ID_PATIENT)
);

/*==============================================================*/
/* Table : PRESCRIPTEUR                                         */
/*==============================================================*/
create table PRESCRIPTEUR
(
   ID_PRESCRIPTEUR      bigint not null AUTO_INCREMENT,
   NOM                  varchar(20),
   PRENOM               varchar(20),
   ADDRESS              text,
   EMAIL                varchar(100),
   NOTES                text,
   primary key (ID_PRESCRIPTEUR)
);


/*==============================================================*/
/* Table : PRESCRIPTION                                         */
/*==============================================================*/
create table PRESCRIPTION
(
   ID_PRESCRIPTION      bigint not null AUTO_INCREMENT,
   DATA                 varchar(100),
   primary key (ID_PRESCRIPTION)
);


/*==============================================================*/
/* Table : PROTOCOLE                                            */
/*==============================================================*/
create table PROTOCOLE
(
   ID_PROTOCOLE         bigint not null AUTO_INCREMENT,
   NOTES                text,
   primary key (ID_PROTOCOLE)
);


/*==============================================================*/
/* Table : RDV                                                  */
/*==============================================================*/
create table RDV
(
   ID_RENDER_VOUS       bigint not null AUTO_INCREMENT,
   ID_SESSION           bigint not null,
   ETATS                varchar(10),
   NOTE                 text,
   MOTIF                varchar(20),
   DATE_RENDEZ_VOUS     date,
   primary key (ID_RENDER_VOUS)
);


/*==============================================================*/
/* Table : SESSION                                              */
/*==============================================================*/
create table SESSION
(
   ID_SESSION           bigint not null AUTO_INCREMENT,
   ID_PRESCRIPTION      bigint not null,
   ID_PATIENT           bigint not null,
   ID_PRESCRIPTEUR      bigint not null,
   DATE_DEPART          date,
   TYPE_DE_SESSION      varchar(10),
   NBR_SEANCE           smallint,
   STAT                 varchar(10),
   DOSSIER_MEDICAL      varchar(50),
   NOTES                text,
   primary key (ID_SESSION)
);


/*==============================================================*/
/* Table : TECHNIQUES                                           */
/*==============================================================*/
create table TECHNIQUES
(
   ID_TECHNIQUE         bigint not null AUTO_INCREMENT,
   NOTES                text,
   primary key (ID_TECHNIQUE)
);


alter table APPORTE add constraint FK_ASSOCIATION_6 foreign key (ID_FICH)
      references FICH (ID_FICH) on delete CASCADE on update CASCADE;

alter table APPORTE add constraint FK_ASSOCIATION_7 foreign key (ID_OBJECTIF)
      references OBJECTIF (ID_OBJECTIF) on delete CASCADE on update CASCADE;

alter table BILLAN add constraint FK_ASSOCIATION_8 foreign key (ID_FICH)
      references FICH (ID_FICH) on delete CASCADE on update CASCADE;

alter table CONTIENT add constraint FK_ASSOCIATION_12 foreign key (ID_PROTOCOLE)
      references PROTOCOLE (ID_PROTOCOLE) on delete CASCADE on update CASCADE;

alter table CONTIENT add constraint FK_ASSOCIATION_9 foreign key (ID_FICH)
      references FICH (ID_FICH) on delete CASCADE on update CASCADE;

alter table FICH add constraint FK_ASSOCIATION_5 foreign key (ID_SESSION)
      references SESSION (ID_SESSION) on delete CASCADE on update CASCADE;

alter table INCLUS add constraint FK_ASSOCIATION_10 foreign key (ID_PROTOCOLE)
      references PROTOCOLE (ID_PROTOCOLE) on delete CASCADE on update CASCADE;

alter table INCLUS add constraint FK_ASSOCIATION_11 foreign key (ID_TECHNIQUE)
      references TECHNIQUES (ID_TECHNIQUE) on delete CASCADE on update CASCADE;

alter table RDV add constraint FK_ASSOCIATION_4 foreign key (ID_SESSION)
      references SESSION (ID_SESSION) on delete cascade on update cascade;

alter table SESSION add constraint FK_ASSOCIATION_2 foreign key (ID_PRESCRIPTEUR)
      references PRESCRIPTEUR (ID_PRESCRIPTEUR) on delete CASCADE on update CASCADE;

alter table SESSION add constraint FK_ASSOCIATION_3 foreign key (ID_PRESCRIPTION)
      references PRESCRIPTION (ID_PRESCRIPTION) on delete CASCADE on update CASCADE;

alter table SESSION add constraint FK_CONCERNE foreign key (ID_PATIENT)
      references PATIENT (ID_PATIENT) on delete CASCADE on update CASCADE;

