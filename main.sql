/*
 Navicat Premium Data Transfer

 Source Server         : Bill_Splitter
 Source Server Type    : SQLite
 Source Server Version : 3030001
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3030001
 File Encoding         : 65001

 Date: 19/02/2024 13:24:52
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for contribution
-- ----------------------------
DROP TABLE IF EXISTS "contribution";
CREATE TABLE "contribution" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "eventdata" integer,
  "amount" real,
  "remark" TEXT
);

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
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS "member";
CREATE TABLE "member" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" TEXT
);

-- ----------------------------
-- Table structure for sessiondata
-- ----------------------------
DROP TABLE IF EXISTS "sessiondata";
CREATE TABLE "sessiondata" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" TEXT,
  "place" TEXT,
  "active" integer,
  "date" TEXT
);

-- ----------------------------
-- Table structure for sqlite_sequence
-- ----------------------------
DROP TABLE IF EXISTS "sqlite_sequence";
CREATE TABLE "sqlite_sequence" (
  "name" ,
  "seq" 
);

-- ----------------------------
-- Auto increment value for contribution
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 15 WHERE name = 'contribution';

-- ----------------------------
-- Auto increment value for event_item
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 128 WHERE name = 'event_item';

-- ----------------------------
-- Auto increment value for item
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 39 WHERE name = 'item';

-- ----------------------------
-- Auto increment value for member
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 15 WHERE name = 'member';

-- ----------------------------
-- Auto increment value for sessiondata
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 6 WHERE name = 'sessiondata';

PRAGMA foreign_keys = true;
