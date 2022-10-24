
-- SQLINES DEMO *** le SQL Developer Data Modeler 22.2.0.165.1149
-- SQLINES DEMO *** -10-22 19:49:46 COT
-- SQLINES DEMO *** le Database 11g
-- SQLINES DEMO *** le Database 11g



-- SQLINES DEMO *** no DDL - MDSYS.SDO_GEOMETRY

-- SQLINES DEMO *** no DDL - XMLTYPE

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE admission_request (
    id          BIGINT NOT NULL,
    rgroup_id   BIGINT,
    user_id     BIGINT,
    status_id   BIGINT,
    description VARCHAR(500),
    start_date  TIMESTAMP(0) NOT NULL,
    finish_date TIMESTAMP(0)
);

COMMENT ON COLUMN admission_request.id IS
    'Auto-generated';

COMMENT ON COLUMN admission_request.description IS
    'Text filled out by petitioning member which is then read by the rgroup leader when reviewing the arequest.';

COMMENT ON COLUMN admission_request.finish_date IS
    'Date that the arequest receives an approved or denied status.';

ALTER TABLE admission_request ADD CONSTRAINT admission_request_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE admission_status (
    id     BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL
);

COMMENT ON COLUMN admission_status.id IS
    'Auto-generated';

COMMENT ON COLUMN admission_status.status IS
    'Id:	Status:		Description:
1	new		Not yet seen by the rg leader.
2	pending		Seen by the rg leader but not fully processed.
3	approved	Approved by rgroup leader.
4	denied		Denied by rgroup leader.';

ALTER TABLE admission_status ADD CONSTRAINT admission_status_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE external_author (
    id         BIGINT NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name  VARCHAR(20) NOT NULL
);

COMMENT ON COLUMN external_author.id IS
    'Auto-generated';

ALTER TABLE external_author ADD CONSTRAINT external_author_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE faculty (
    id   BIGINT NOT NULL,
    name VARCHAR(30) NOT NULL
);

COMMENT ON COLUMN faculty.id IS
    'Auto-generated';

ALTER TABLE faculty ADD CONSTRAINT faculty_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE financing_source (
    id     BIGINT NOT NULL,
    source VARCHAR(15) NOT NULL
);

COMMENT ON COLUMN financing_source.id IS
    'Auto-generated';

COMMENT ON COLUMN financing_source.source IS
    'Id:	Status:
1	internal
2	external	';

ALTER TABLE financing_source ADD CONSTRAINT financing_source_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE financing_type (
    id   BIGINT NOT NULL,
    type VARCHAR(20) NOT NULL
);

COMMENT ON COLUMN financing_type.id IS
    'Auto-generated';

COMMENT ON COLUMN financing_type.type IS
    'Id:	Status:
1	subsidized
2	private	';

ALTER TABLE financing_type ADD CONSTRAINT financing_type_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE great_rarea (
    id          BIGINT NOT NULL,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL
);

COMMENT ON COLUMN great_rarea.id IS
    'Auto-generated';

COMMENT ON COLUMN great_rarea.name IS
    'Id:	Great rarea:
1	agriculture Sciences
2	social Sciences
3	humanities
4	natural Sciences
5	engineering and IT
6	health and medical sciences';

COMMENT ON COLUMN great_rarea.description IS
    'General description.';

ALTER TABLE great_rarea ADD CONSTRAINT great_rarea_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE institution (
    id   BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL
);

COMMENT ON COLUMN institution.id IS
    'Auto-generated';

COMMENT ON COLUMN institution.name IS
    'Id:	Institution name:					Description:
1	Universidad Icesi';

ALTER TABLE institution ADD CONSTRAINT institution_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE minciencias_category (
    id       BIGINT
        CONSTRAINT nnc_admission_statusv1_id NOT NULL,
    category VARCHAR(20) NOT NULL
);

COMMENT ON COLUMN minciencias_category.id IS
    'Auto-generated';

COMMENT ON COLUMN minciencias_category.category IS
    'Id:	Category:	Description:
1	A1		Top 25%
2	A		Top 50%
3	B		Top 25%
4	C		Top 0% (2 years experience)
5	D		Top 0% (1 year experience)';

ALTER TABLE minciencias_category ADD CONSTRAINT minciencias_category_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE publication_author (
    resource_id BIGINT NOT NULL,
    users_id    BIGINT NOT NULL
);

ALTER TABLE publication_author ADD CONSTRAINT publication_author_pk PRIMARY KEY ( resource_id,
                                                                                  users_id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE publication_eauthor (
    resource_id        BIGINT NOT NULL,
    external_author_id BIGINT NOT NULL
);

ALTER TABLE publication_eauthor ADD CONSTRAINT publication_eauthor_pk PRIMARY KEY ( external_author_id,
                                                                                    resource_id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE research_area (
    id          BIGINT NOT NULL,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL,
    grarea_id   BIGINT
);

COMMENT ON COLUMN research_area.id IS
    'Auto-generated';

COMMENT ON COLUMN research_area.description IS
    'General description.';

COMMENT ON COLUMN research_area.grarea_id IS
    'Great area id';

ALTER TABLE research_area ADD CONSTRAINT research_area_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE research_group (
    id                    BIGINT NOT NULL,
    name                  VARCHAR(30) NOT NULL,
    leader_id             BIGINT NOT NULL,
    institution_id        BIGINT NOT NULL,
    faculty_id            BIGINT NOT NULL,
    mciencias_category_id BIGINT NOT NULL,
    description           VARCHAR(500) NOT NULL,
    nprogram_id           BIGINT
);

COMMENT ON COLUMN research_group.id IS
    'Auto-generated';

COMMENT ON COLUMN research_group.name IS
    'Full name of the research group';

COMMENT ON COLUMN research_group.description IS
    'General description.';

ALTER TABLE research_group ADD CONSTRAINT research_group_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE research_line (
    id          BIGINT NOT NULL,
    name        VARCHAR(40) NOT NULL,
    description VARCHAR(500) NOT NULL,
    rgroup_id   BIGINT NOT NULL,
    rarea_id    BIGINT
);

COMMENT ON COLUMN research_line.id IS
    'Auto-generated. This entity may also be refered to as ''research discipline''.';

COMMENT ON COLUMN research_line.rarea_id IS
    'Research area id';

ALTER TABLE research_line ADD CONSTRAINT research_line_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE research_paper (
    id               BIGINT NOT NULL,
    title            VARCHAR(300) NOT NULL,
    academic_journal VARCHAR(50) NOT NULL
);

COMMENT ON COLUMN research_paper.id IS
    'Auto-generated';

COMMENT ON COLUMN research_paper.title IS
    'Full title of the rpaper';

COMMENT ON COLUMN research_paper.academic_journal IS
    'Name of the academic journal that the rpaper was published to.';

ALTER TABLE research_paper ADD CONSTRAINT research_paper_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE research_project (
    id          BIGINT NOT NULL,
    title       VARCHAR(300) NOT NULL,
    description VARCHAR(4000) NOT NULL,
    start_date  TIMESTAMP(0) NOT NULL,
    finish_date TIMESTAMP(0),
    rline_id    BIGINT,
    status_id   BIGINT,
    rtype_id    BIGINT,
    ftype_id    BIGINT,
    fsource_id  BIGINT
);

COMMENT ON COLUMN research_project.id IS
    'Auto-generated';

COMMENT ON COLUMN research_project.title IS
    'Full title of the rproject';

COMMENT ON COLUMN research_project.description IS
    'General description. Also works as a summary';

COMMENT ON COLUMN research_project.finish_date IS
    'Date that the arequest receives an approved or denied status.';

ALTER TABLE research_project ADD CONSTRAINT research_project_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE "resource" (
    id            BIGINT NOT NULL,
    description   VARCHAR(500) NOT NULL,
    publish_date  TIMESTAMP(0) NOT NULL,
    rproject_id   BIGINT,
    resource_url  VARCHAR(200) NOT NULL,
    visibility_id BIGINT
);

COMMENT ON COLUMN "resource".id IS
    'Auto-generated';

COMMENT ON COLUMN "resource".description IS
    'Public, general description of the publication';

ALTER TABLE "resource" ADD CONSTRAINT resource_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE resource_visibilities (
    id         BIGINT NOT NULL,
    visibility VARCHAR(20) NOT NULL
);

COMMENT ON COLUMN resource_visibilities.id IS
    'Auto-generated';

COMMENT ON COLUMN resource_visibilities.visibility IS
    'Id:	Visibility:
1	public
2	private	';

ALTER TABLE resource_visibilities ADD CONSTRAINT resource_visibilities_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE rgroup_leaders (
    rgroup_id               BIGINT NOT NULL,
    leader_id               BIGINT NOT NULL,
    leader_citizen_id       VARCHAR(20) NOT NULL,
    leader_nationality      VARCHAR(20) NOT NULL,
    leader_second_last_name VARCHAR(20),
    leader_country_of_birth VARCHAR(30) NOT NULL
);

ALTER TABLE rgroup_leaders ADD CONSTRAINT rgroup_leaders_pk PRIMARY KEY ( rgroup_id,
                                                                          leader_id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE rgroup_rproject (
    research_group_id   BIGINT NOT NULL,
    research_project_id BIGINT NOT NULL
);

ALTER TABLE rgroup_rproject ADD CONSTRAINT rgroup_rproject_pk PRIMARY KEY ( research_group_id,
                                                                            research_project_id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE rgroup_users (
    research_group_id BIGINT NOT NULL,
    users_id          BIGINT NOT NULL,
    user_entry        TIMESTAMP(0) NOT NULL,
    user_exit         TIMESTAMP(0)
);

ALTER TABLE rgroup_users ADD CONSTRAINT rgroup_users_pk PRIMARY KEY ( research_group_id,
                                                                      users_id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE rproject_goal (
    id          BIGINT NOT NULL,
    description VARCHAR(200) NOT NULL,
    is_finished CHAR(1) NOT NULL,
    rproject_id BIGINT NOT NULL
);

COMMENT ON COLUMN rproject_goal.id IS
    'Auto-generated';

COMMENT ON COLUMN rproject_goal.is_finished IS
    'Binary value that shows whether the objective has been completed
Char:	Description:
C	completed
P	pending';

ALTER TABLE rproject_goal ADD CONSTRAINT rproject_goal_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE rproject_rpapers (
    research_project_id BIGINT NOT NULL,
    research_paper_id   BIGINT NOT NULL,
    is_project_member   BYTEA NOT NULL
);

ALTER TABLE rproject_rpapers ADD CONSTRAINT rproject_rpapers_pk PRIMARY KEY ( research_project_id,
                                                                              research_paper_id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE rproject_status (
    id     BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL
);

COMMENT ON COLUMN rproject_status.status IS
    'Id:	Status:		Description:
1	planning	
2	design		
3	execution	
4	submission	';

ALTER TABLE rproject_status ADD CONSTRAINT rproject_status_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE rproject_types (
    id   BIGINT NOT NULL,
    type VARCHAR(100) NOT NULL
);

COMMENT ON COLUMN rproject_types.id IS
    'Auto-generated.';

COMMENT ON COLUMN rproject_types.type IS
    'Id:	Type:						Description:
1	research and development
2	research, development and innovation
3	science technologies accountability and growth	
4	research and creation';

ALTER TABLE rproject_types ADD CONSTRAINT rproject_types_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE rproject_users (
    research_project_id BIGINT NOT NULL,
    users_id            BIGINT NOT NULL,
    member_role         VARCHAR(20) NOT NULL
);

ALTER TABLE rproject_users ADD CONSTRAINT rproject_users_pk PRIMARY KEY ( research_project_id,
                                                                          users_id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE sci_ti_national_program (
    id          BIGINT NOT NULL,
    name        VARCHAR(200) NOT NULL,
    description VARCHAR(500) NOT NULL
);

COMMENT ON COLUMN sci_ti_national_program.id IS
    'Auto-generated';

COMMENT ON COLUMN sci_ti_national_program.name IS
    'Id:	Great rarea:
1	biotechnology
2	science, technology and health innovation
3	marine science and hydrobiological resources
4	science, technology and innovation in agricultural science
5	science
6	science, technology and innovation in environment, biodiversity and habitat
7	science, technology and innovation in human science, social sciences and education.
8	science, technology and innovation in TI and communications
9	energy and mining research
10	science, technology and innovation in defense and security
11	science, technology and innovation in geological science
12	science, technology and innovation in engineering';

COMMENT ON COLUMN sci_ti_national_program.description IS
    'General description.';

ALTER TABLE sci_ti_national_program ADD CONSTRAINT sci_ti_national_program_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE student_program (
    id   BIGINT NOT NULL,
    name VARCHAR(50) NOT NULL
);

COMMENT ON COLUMN student_program.id IS
    'Auto-generated';

ALTER TABLE student_program ADD CONSTRAINT student_program_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE user_types (
    id   BIGINT NOT NULL,
    type VARCHAR(50) NOT NULL
);

COMMENT ON COLUMN user_types.id IS
    'Auto-generated';

COMMENT ON COLUMN user_types.type IS
    'Id:	Type:
1	professor
2	student';

ALTER TABLE user_types ADD CONSTRAINT user_types_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE users (
    id            BIGINT NOT NULL,
    username      VARCHAR(20) NOT NULL,
    first_name    VARCHAR(20) NOT NULL,
    last_name     VARCHAR(20) NOT NULL,
    dob           TIMESTAMP(0) NOT NULL,
    password      VARCHAR(30) NOT NULL,
    email         VARCHAR(50) NOT NULL,
    user_picture  BYTEA,
    user_types_id BIGINT
);

COMMENT ON COLUMN users.id IS
    'Id must correspond with id returned from external system accessed through SSO';

COMMENT ON COLUMN users.dob IS
    'Date of birth';

COMMENT ON COLUMN users.user_picture IS
    'Up to 64kb size.';

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY ( id );

-- SQLINES LICENSE FOR EVALUATION USE ONLY
CREATE TABLE users_sprogram (
    users_id           BIGINT NOT NULL,
    student_program_id BIGINT NOT NULL
);

ALTER TABLE users_sprogram ADD CONSTRAINT users_sprogram_pk PRIMARY KEY ( users_id,
                                                                          student_program_id );

ALTER TABLE admission_request
    ADD CONSTRAINT admission_request_users_fk FOREIGN KEY ( user_id )
        REFERENCES users ( id )
            ON DELETE CASCADE;

ALTER TABLE admission_request
    ADD CONSTRAINT arequest_astatus_fk FOREIGN KEY ( status_id )
        REFERENCES admission_status ( id );

ALTER TABLE admission_request
    ADD CONSTRAINT arequest_rgroup_fk FOREIGN KEY ( rgroup_id )
        REFERENCES research_group ( id )
            ON DELETE CASCADE;

ALTER TABLE publication_eauthor
    ADD CONSTRAINT pub_eauthor_eauthor_fk FOREIGN KEY ( external_author_id )
        REFERENCES external_author ( id );

ALTER TABLE publication_eauthor
    ADD CONSTRAINT pub_eauthor_resource_fk FOREIGN KEY ( resource_id )
        REFERENCES "resource" ( id );

ALTER TABLE publication_author
    ADD CONSTRAINT publication_author_resource_fk FOREIGN KEY ( resource_id )
        REFERENCES "resource" ( id );

ALTER TABLE publication_author
    ADD CONSTRAINT publication_author_users_fk FOREIGN KEY ( users_id )
        REFERENCES users ( id );

ALTER TABLE "resource"
    ADD CONSTRAINT res_res_visibilities_fk FOREIGN KEY ( visibility_id )
        REFERENCES resource_visibilities ( id );

ALTER TABLE research_area
    ADD CONSTRAINT research_area_great_rarea_fk FOREIGN KEY ( grarea_id )
        REFERENCES great_rarea ( id )
            ON DELETE CASCADE;

ALTER TABLE research_group
    ADD CONSTRAINT research_group_faculty_fk FOREIGN KEY ( faculty_id )
        REFERENCES faculty ( id );

ALTER TABLE research_group
    ADD CONSTRAINT research_group_institution_fk FOREIGN KEY ( institution_id )
        REFERENCES institution ( id );

ALTER TABLE research_line
    ADD CONSTRAINT research_line_research_area_fk FOREIGN KEY ( rarea_id )
        REFERENCES research_area ( id )
            ON DELETE CASCADE;

ALTER TABLE research_paper
    ADD CONSTRAINT research_paper_resource_fk FOREIGN KEY ( id )
        REFERENCES "resource" ( id );

ALTER TABLE "resource"
    ADD CONSTRAINT resource_research_project_fk FOREIGN KEY ( rproject_id )
        REFERENCES research_project ( id );

ALTER TABLE research_group
    ADD CONSTRAINT rgroup_leader_fk FOREIGN KEY ( leader_id )
        REFERENCES users ( id );

ALTER TABLE rgroup_leaders
    ADD CONSTRAINT rgroup_leaders_rgroup_fk FOREIGN KEY ( rgroup_id )
        REFERENCES research_group ( id );

ALTER TABLE research_group
    ADD CONSTRAINT rgroup_mciencias_category_fk FOREIGN KEY ( mciencias_category_id )
        REFERENCES minciencias_category ( id );

ALTER TABLE rgroup_rproject
    ADD CONSTRAINT rgroup_rproject_rgroup_fk FOREIGN KEY ( research_group_id )
        REFERENCES research_group ( id );

ALTER TABLE rgroup_rproject
    ADD CONSTRAINT rgroup_rproject_rproject_fk FOREIGN KEY ( research_project_id )
        REFERENCES research_project ( id );

ALTER TABLE research_group
    ADD CONSTRAINT rgroup_sciti_nat_program_fk FOREIGN KEY ( nprogram_id )
        REFERENCES sci_ti_national_program ( id );

ALTER TABLE rgroup_users
    ADD CONSTRAINT rgroup_users_research_group_fk FOREIGN KEY ( research_group_id )
        REFERENCES research_group ( id );

ALTER TABLE rgroup_users
    ADD CONSTRAINT rgroup_users_users_fk FOREIGN KEY ( users_id )
        REFERENCES users ( id );

ALTER TABLE research_line
    ADD CONSTRAINT rline_rgroup_fk FOREIGN KEY ( rgroup_id )
        REFERENCES research_group ( id )
            ON DELETE CASCADE;

ALTER TABLE research_project
    ADD CONSTRAINT rproject_fin_source_fk FOREIGN KEY ( fsource_id )
        REFERENCES financing_source ( id );

ALTER TABLE research_project
    ADD CONSTRAINT rproject_fin_type_fk FOREIGN KEY ( ftype_id )
        REFERENCES financing_type ( id );

ALTER TABLE rproject_goal
    ADD CONSTRAINT rproject_goal_rproject_fk FOREIGN KEY ( rproject_id )
        REFERENCES research_project ( id );

ALTER TABLE research_project
    ADD CONSTRAINT rproject_rline_fk FOREIGN KEY ( rline_id )
        REFERENCES research_line ( id );

ALTER TABLE rproject_rpapers
    ADD CONSTRAINT rproject_rpapers_rpaper_fk FOREIGN KEY ( research_paper_id )
        REFERENCES research_paper ( id );

ALTER TABLE rproject_rpapers
    ADD CONSTRAINT rproject_rpapers_rproject_fk FOREIGN KEY ( research_project_id )
        REFERENCES research_project ( id );

ALTER TABLE research_project
    ADD CONSTRAINT rproject_rproject_status_fk FOREIGN KEY ( status_id )
        REFERENCES rproject_status ( id );

ALTER TABLE research_project
    ADD CONSTRAINT rproject_rproject_types_fk FOREIGN KEY ( rtype_id )
        REFERENCES rproject_types ( id );

ALTER TABLE rproject_users
    ADD CONSTRAINT rproject_users_rproject_fk FOREIGN KEY ( research_project_id )
        REFERENCES research_project ( id );

ALTER TABLE rproject_users
    ADD CONSTRAINT rproject_users_users_fk FOREIGN KEY ( users_id )
        REFERENCES users ( id );

ALTER TABLE users_sprogram
    ADD CONSTRAINT users_sprogram_sprogram_fk FOREIGN KEY ( student_program_id )
        REFERENCES student_program ( id );

ALTER TABLE users_sprogram
    ADD CONSTRAINT users_sprogram_users_fk FOREIGN KEY ( users_id )
        REFERENCES users ( id );

ALTER TABLE users
    ADD CONSTRAINT users_user_types_fk FOREIGN KEY ( user_types_id )
        REFERENCES user_types ( id );

CREATE SEQUENCE admission_request_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;
CREATE SEQUENCE admission_status_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;
CREATE SEQUENCE external_author_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE faculty_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE financing_source_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;

CREATE SEQUENCE financing_type_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE great_rarea_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE institution_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE minciencias_category_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE research_area_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE rg_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;

CREATE SEQUENCE research_line_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE research_project_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;

CREATE SEQUENCE resource_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE resource_visibilities_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE rproject_goal_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE sci_ti_national_program_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE student_program_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


CREATE SEQUENCE user_types_id_seq START WITH 1 /* Warning: NOCACHE */ /* Warning: ORDER */;


-- SQLINES DEMO *** per Data Modeler Summary Report: 
-- 
-- SQLINES DEMO ***                        31
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                        67
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO *** DY                      0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                        19
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***  TYPE                   0
-- SQLINES DEMO ***  TYPE                   0
-- SQLINES DEMO ***  TYPE BODY              0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO *** EGMENT                  0
-- SQLINES DEMO ***                        19
-- SQLINES DEMO *** ED VIEW                 0
-- SQLINES DEMO *** ED VIEW LOG             0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- 
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
-- 
-- SQLINES DEMO ***                         0
-- 
-- SQLINES DEMO ***                         0
-- SQLINES DEMO *** A                       0
-- SQLINES DEMO *** T                       0
-- 
-- SQLINES DEMO ***                         0
-- SQLINES DEMO ***                         0
