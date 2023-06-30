/*
 * Coordinates_Typ
 * speichert x-, y- unt z-Koordinaten
 */
CREATE TYPE Coordinates_Type AS OBJECT (
    xCoord  FLOAT,
    yCoord  FLOAT,
    zCoord FLOAT
);
/
/*
 * Claimbuild_Typ
 * speichert ein Claimbuild mit dessen ID, Namen, Typ und Koordinaten
 */
CREATE TYPE Claimbuild_Type AS OBJECT (
    cbID INT,
    cbName VARCHAR(50),
    cbType varchar(50),
    coordinates Coordinates_Type
);
/
/*
 * Aliases_Typ
 * speichert eine ID und den AliasNamen, sprich das Alias, in einem eigenen Typ.
 * wir nutzen einen eignene Typ, da wir keine Obergrenze haben und somit eine Nested-Table nutzen.
 */
 CREATE TYPE Aliases_Type AS OBJECT (
    aliasID INT,
    aliasName VARCHAR(50)
);
/
CREATE TYPE Aliases_NT AS TABLE OF REF Aliases_Type;
/*
 * Faction_Type
 * speichert eine Faction mit der ID, dem Namen, dem Buff, der Farbe, das In-Game-Alignment und den Alias-Namen.
 */
CREATE TYPE Faction_Type AS OBJECT (
    FacID INT,
    FacName VARCHAR(50),
    FacBuff VARCHAR(200),
    FacColor VARCHAR(7),
    Alignment VARCHAR(50),
    Aliases Aliases_NT
    /* Der Aliases_Type wird in der Tabelle eingebunden */
);
/

CREATE TYPE Gear_Type AS OBJECT
(
    gearID INT,
    gearName VARCHAR(50),
    durability FLOAT
)NOT FINAL;
/
CREATE TYPE Weapon_Type UNDER Gear_Type
(
    weaponType VARCHAR(50),
    damage FLOAT
);
/
CREATE TYPE Armour_Type UNDER Gear_Type
(
    armourType VARCHAR(50),
    armourProt FLOAT
);
/
/*
 * ============================
 * Tabellen deklaration ab hier
 * ============================
 */

CREATE TABLE Factions OF Faction_Type(
    FacID PRIMARY KEY
)
    NESTED TABLE Aliases STORE AS Aliases_NT_TAB;
/
 CREATE TABLE Claimbuilds OF Claimbuild_Type;
/
CREATE TABLE Armour OF Armour_Type;
/
CREATE TABLE Weapon OF Weapon_Type;

