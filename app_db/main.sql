/*
 Navicat Premium Data Transfer

 Source Server         : BillSpiltter
 Source Server Type    : SQLite
 Source Server Version : 3030001
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3030001
 File Encoding         : 65001

 Date: 28/01/2024 21:44:54
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for _event_item_old_20240128
-- ----------------------------
DROP TABLE IF EXISTS "_event_item_old_20240128";
CREATE TABLE "_event_item_old_20240128" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "eventdata" integer,
  "item" integer,
  "cost_precentage" real,
  CONSTRAINT "BS_FK_EVENT_ITEM_SESSIONDATA" FOREIGN KEY ("eventdata") REFERENCES "eventdata" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT "BS+FK_EVENT_ITEM_ITEM" FOREIGN KEY ("item") REFERENCES "item" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- ----------------------------
-- Records of _event_item_old_20240128
-- ----------------------------

-- ----------------------------
-- Table structure for _item_old_20240128
-- ----------------------------
DROP TABLE IF EXISTS "_item_old_20240128";
CREATE TABLE "_item_old_20240128" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "sessiondata" integer,
  "name" TEXT,
  "amount" real,
  "tax" real,
  "total" real
);

-- ----------------------------
-- Records of _item_old_20240128
-- ----------------------------

-- ----------------------------
-- Table structure for event_item
-- ----------------------------
DROP TABLE IF EXISTS "event_item";
CREATE TABLE "event_item" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "eventdata" integer,
  "item" integer,
  CONSTRAINT "BS_FK_EVENT_ITEM_SESSIONDATA" FOREIGN KEY ("eventdata") REFERENCES "eventdata" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT "BS+FK_EVENT_ITEM_ITEM" FOREIGN KEY ("item") REFERENCES "item" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- ----------------------------
-- Records of event_item
-- ----------------------------
INSERT INTO "event_item" VALUES (1, 1, 3);
INSERT INTO "event_item" VALUES (2, 2, 1);
INSERT INTO "event_item" VALUES (3, 5, 1);
INSERT INTO "event_item" VALUES (4, 1, 1);
INSERT INTO "event_item" VALUES (5, 2, 5);
INSERT INTO "event_item" VALUES (6, 5, 5);
INSERT INTO "event_item" VALUES (7, 1, 4);
INSERT INTO "event_item" VALUES (8, 2, 4);

-- ----------------------------
-- Table structure for eventdata
-- ----------------------------
DROP TABLE IF EXISTS "eventdata";
CREATE TABLE "eventdata" (
  "id" INTEGER NOT NULL,
  "sessiondata" integer NOT NULL,
  "member" integer NOT NULL,
  "remark" text,
  PRIMARY KEY ("id"),
  CONSTRAINT "BS_FK_SESSIONDATA" FOREIGN KEY ("sessiondata") REFERENCES "sessiondata" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT "BK_FK_MEMBER" FOREIGN KEY ("member") REFERENCES "member" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- ----------------------------
-- Records of eventdata
-- ----------------------------
INSERT INTO "eventdata" VALUES (1, 2, 2, '2024-01-27 16:38:34');
INSERT INTO "eventdata" VALUES (2, 2, 1, '2024-01-27 16:44:22');
INSERT INTO "eventdata" VALUES (3, 1, 2, '2024-01-27 16:44:44');
INSERT INTO "eventdata" VALUES (4, 1, 1, '2024-01-27 16:44:50');
INSERT INTO "eventdata" VALUES (5, 2, 3, '2024-01-28 14:20:11');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS "item";
CREATE TABLE "item" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "sessiondata" integer,
  "name" TEXT,
  "amount" real,
  "tax" real,
  "total" real,
  CONSTRAINT "BS_FK_SESSIONDATA_ITEM" FOREIGN KEY ("sessiondata") REFERENCES "sessiondata" ("id") ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO "item" VALUES (1, 2, 'Ascott Dry Gin', 6000.0, 0.0, 6000.0);
INSERT INTO "item" VALUES (3, 2, 'Soda', 300.0, 0.0, 300.0);
INSERT INTO "item" VALUES (4, 2, 'Cigrett', 3200.0, 0.0, 3200.0);
INSERT INTO "item" VALUES (5, 2, 'Sprite', 800.0, 0.0, 800.0);

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS "member";
CREATE TABLE "member" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" TEXT
);

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO "member" VALUES (1, 'Lashan Chandika');
INSERT INTO "member" VALUES (2, 'Rahul Satheesh');
INSERT INTO "member" VALUES (3, 'Dakshina');

-- ----------------------------
-- Table structure for sessiondata
-- ----------------------------
DROP TABLE IF EXISTS "sessiondata";
CREATE TABLE "sessiondata" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" TEXT,
  "place" TEXT
);

-- ----------------------------
-- Records of sessiondata
-- ----------------------------
INSERT INTO "sessiondata" VALUES (1, 'Test Party', 'MCA');
INSERT INTO "sessiondata" VALUES (2, 'Test Session 2', 'BMICH');

-- ----------------------------
-- Table structure for sqlite_sequence
-- ----------------------------
DROP TABLE IF EXISTS "sqlite_sequence";
CREATE TABLE "sqlite_sequence" (
  "name" ,
  "seq" 
);

-- ----------------------------
-- Records of sqlite_sequence
-- ----------------------------
INSERT INTO "sqlite_sequence" VALUES ('sessiondata', 2);
INSERT INTO "sqlite_sequence" VALUES ('member', 3);
INSERT INTO "sqlite_sequence" VALUES ('item', 5);
INSERT INTO "sqlite_sequence" VALUES ('event_item', 8);

-- ----------------------------
-- Auto increment value for event_item
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 8 WHERE name = 'event_item';

-- ----------------------------
-- Auto increment value for item
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 5 WHERE name = 'item';

-- ----------------------------
-- Auto increment value for member
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 3 WHERE name = 'member';

-- ----------------------------
-- Auto increment value for sessiondata
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 2 WHERE name = 'sessiondata';

PRAGMA foreign_keys = true;
