#!/bin/bash
javac avajlauncher/classes/*.java avajlauncher/classes/aircrafts/*.java
java avajlauncher/classes/Simulator.java $1
