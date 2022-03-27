CREATE TABLE IF NOT EXISTS TestValues(
    id              INTEGER PRIMARY KEY ,
    emptyCapWeight  DECIMAL(2) NOT NULL ,
    fullCapWeight   DECIMAL(2) NOT NULL,
    hitch           DECIMAL(2) NOT NULL,
    compHeight      DECIMAL(2) NOT NULL,
    fullHeight      DECIMAL(2) NOT NULL,
    actuationTime   DECIMAL(2) NOT NULL,
    imas            DECIMAL(2) NOT NULL,
    ilin            DECIMAL(2) NOT NULL,
    density         DECIMAL(2) NOT NULL
);