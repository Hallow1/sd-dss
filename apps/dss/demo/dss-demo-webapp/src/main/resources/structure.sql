CREATE TABLE PREFERENCES ( PREF_KEY 	VARCHAR(50) NOT NULL, PREF_VALUE 	VARCHAR(200), PRIMARY KEY (PREF_KEY));
CREATE TABLE PROXY_PREFERENCES ( PROXY_KEY 	VARCHAR(50) NOT NULL, PROXY_VALUE 	VARCHAR(200), PRIMARY KEY (PROXY_KEY));
CREATE TABLE POLICIES (POLICY_KEY VARCHAR(200) NOT NULL, POLICY_LEVEL VARCHAR(20), PRIMARY KEY(POLICY_KEY));
CREATE TABLE CONSTRAINTS (CONSTRAINT_TYPE VARCHAR(15) NOT NULL, CONSTRAINT_DIGEST VARCHAR(50) , CONSTRAINT_SIGNATURE VARCHAR(50), CONSTRAINT_KEY_LENGTH TINYINT, PRIMARY KEY(CONSTRAINT_TYPE));