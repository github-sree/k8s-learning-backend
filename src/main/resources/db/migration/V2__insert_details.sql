-- INSERT INTO USERS (ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, EMAIL, ENABLED, FIRST_PRIVILEGE_NAME, LAST_PRIVILEGE_NAME, PASSWORD, ROLE_ID, USER_PRIVILEGE_NAME, USER_ID, INITIAL_USER) VALUES ( true, true, true ,'sree550k@gmail.com', true , null ,'sreedhar.k','$2a$10$qh7R/5L/keN/1AvlHTftdeS5LalcnDmcZrHdIydaC.MneeDDUh5VG', null ,'sree550k','67aeeae5-ef8f-467a-bf22-3aeb06f54513', true )

-- PRIVILEGE DATA
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('a4fd99b9-2ff6-4a0e-b331-fcadde3ee70d','ROLES_CREATE',1000);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('97d816d5-35bc-4e39-94a8-f22aff0979b3','ROLES_READ',1001);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('66d667c4-8858-47c8-8129-d5f9094ac357','ROLES_UPDATE',1002);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('3ea6fd86-0303-41c2-aabd-b6004a7a4b2a','ROLES_DELETE',1003);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('5422ecfb-d79b-4e0c-869a-cf4523aebee7','PRIVILEGE_CREATE',1004);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('71ecb1a0-ebe6-4d19-9391-ed4eb8500645','PRIVILEGE_READ',1005);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('279b949e-aaa9-4a35-be73-0d2a6150d325','PRIVILEGE_UPDATE',1006);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('e307d741-4e72-487f-bc1f-07e749a1d0ee','PRIVILEGE_DELETE',1007);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('c507dSDF-4e72-487f-bc1f-345435v1d0ee','USER_CREATE',1008);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('ad570a8c-793d-49f4-a582-96b0d1328ad5','USER_READ',1009);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('b4c5d3ad-2b44-4bf7-879d-bc9535df6828','USER_UPDATE',1010);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('skdj93ad-2b44-4bf7-879d-cd9sd5df23fd','USER_DELETE',1011);
INSERT INTO K8_PRIVILEGE (PRIVILEGE_ID,  PRIVILEGE_NAME,   PRIVILEGE_CODE) VALUES ('df8df98f-2b44-dfb4-879d-d98f7d87gf9f','USER_ROLES_ASSIGN',1012);