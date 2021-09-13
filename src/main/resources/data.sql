INSERT INTO author(id,name) VALUES
  (1,'Blok'),
  (2,'Proust'),
  (3,'Shildt');

INSERT INTO genre(id,name) VALUES
  (1,'Poetry'),
  (2,'Fiction'),
  (3,'Non-fiction');

INSERT INTO books(id,name, author, genre, comments) VALUES
  (1,'The sun','1','2',null),
  (2,'The nature','2','1',null)),
  (3,'Snowing', '3','3',null));

INSERT INTO acl_sid (id, principal, sid) VALUES
(1, 1, 'admin'),
(2, 1, 'user'),
(3, 0, 'ROLE_EDITOR');

INSERT INTO acl_class (id, class) VALUES
(1, 'ru.otus.SpringMvcHomework.domain.Book');

INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES
(1, 1, 1, NULL, 3, 0),
(2, 1, 2, NULL, 3, 0),
(3, 1, 3, NULL, 3, 0);

INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask,
                       granting, audit_success, audit_failure) VALUES
(1, 1, 1, 1, 1, 1, 1, 1),
(2, 1, 2, 1, 2, 1, 1, 1),
(3, 1, 3, 3, 1, 1, 1, 1),
(4, 2, 1, 2, 1, 1, 1, 1),
(5, 2, 2, 3, 1, 1, 1, 1),
(6, 3, 1, 3, 1, 1, 1, 1),
(7, 3, 2, 3, 2, 1, 1, 1);
