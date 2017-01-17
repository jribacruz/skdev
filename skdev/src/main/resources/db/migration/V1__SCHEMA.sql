CREATE TABLE sk_action(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(32) NOT NULL,
	description VARCHAR(64) NOT NULL,
	dialoghtml VARCHAR(4098),
	executejs VARCHAR(4098)
);

ALTER TABLE sk_action ADD UNIQUE INDEX act_name_idx(name ASC);

CREATE TABLE sk_template(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(32) NOT NULL,
	content VARCHAR(4098),
	action_id INT NOT NULL,
	FOREIGN KEY fk_tmp_act_id(action_id) REFERENCES sk_action(id) ON DELETE CASCADE
);

CREATE TABLE sk_fragment (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(24),
	fragment VARCHAR(4098),
	category VARCHAR(32)
);



