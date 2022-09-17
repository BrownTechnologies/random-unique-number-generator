# random-unique-number-generator

Unique and random number generator

## Idea and logic

This utility works like clock, so you get unique random numbers per installation.
we generate 16 digit integer value for example `2226015501234239`

### Anatomy of generated unique random big integer value

    22       }--> 1 
    260      }--> 2
    15       }--> 3
    50       }--> 4
    12       }--> 5
    34239    }--> 6

1. These two number represents `year` in which the random number is generated.
2. These three number represents the `day of the year` on which the random number is generated.
3. These two number represents `hour` of the day in which the random number is generated.
4. These two number represents `minutes` of the day in which the random number is generated.
5. These two number represents `seconds` of the day in which the random number is generated.
6. These five number are `random number` which is appended at the end to make is unique and hard to guess.

### Usage

Please refer [tests](src/test/java/in/browntechnologies/AppTest.java#L24) for better understanding of the usage.