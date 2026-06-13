# Gilded Rose starting position in Java

## Run the TextTest Fixture from Command-Line

```
./gradlew -q text
```

### Specify Number of Days

For e.g. 10 days:

```
./gradlew -q text --args 10
```

You should make sure the gradle commands shown above work when you execute them in a terminal before trying to use TextTest (see below).


## Run the TextTest approval test that comes with this project

There are instructions in the [TextTest Readme](../texttests/README.md) for setting up TextTest. What's unusual for the Java version is there are two executables listed in [config.gr](../texttests/config.gr) for Java. The first uses Gradle wrapped in a python script. Uncomment these lines to use it:

    executable:${TEXTTEST_HOME}/Java/texttest_rig.py
    interpreter:python

The other relies on your CLASSPATH being set correctly in [environment.gr](../texttests/environment.gr). Uncomment these lines to use it instead:

    executable:com.gildedrose.TexttestFixture
    interpreter:java

## Teststrategy

Wir haben pro NamedItem eine Testfile gemacht sowie auch ein Testfile für unnamed generic Items.
Die Special Rules sowie allgemeine sachen wurden alle mit Tests getestet.

Special rules:

- Normale Items verlieren pro Tag 1 Qualität.
- Normale Items verlieren nach Ablauf des Verkaufsdatums doppelt so schnell Qualität.
- Qualität darf nie negativ werden.
- Aged Brie gewinnt mit der Zeit an Qualität.
- Backstage Passes steigen stärker im Wert, je näher das Konzert kommt.
- Backstage Passes fallen nach dem Konzert auf Qualität 0.
- Sulfuras verändert weder sellIn noch quality.
- Qualität darf nie über 50 steigen, außer bei Sulfuras mit fixer Qualität 80.

Die größte Schwierigkeit war die einzelnen Rules der items mit Namen herausfinden.



