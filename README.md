# Mars Rover Challenge

A simple implementation for Google's Mars Rover Coding Challenge.

## Building

Building the project to create it's class files can be done with

```shell
>  .\gradlew build
```

You can also generate a `.jar` using

```shell
>  .\gradlew jar
```

## Running

Run the current implementation reading in data from the standard input stream

```shell
>  .\gradlew run
```

## Testing

To test existing tests just run the below command. Note that during the build process all tests are run.

```shell
>  .\gradlew test
```

## Future considerations

The current implementation as many limitations but are however open for extension. Firstly, The `Std` input stream is 
being used for all input and output. Extending a `Transport` gives you opportunity to provide your own means of transport 
whether it's file via reading or a TCP stream, whichever.

The current implementation is a single threaded blocking design. In a proper system this would be un-ideal and looking
at something that follows proper I/O event reactors or delegating work off the main thread would be much better.

In addition to this, if more time was provided I would of followed a more reactive approach where Houston would emit 
new routes to rovers. Rovers would then also emit their new positions to whoever may be listening. 

There is a tiny provision for world simulation. By tiny i mean, a simple foundation is there given the notion that there
is a world entity for rovers to travel on. This may also include terrain that a rover has to navigate around or something
in the case of an AI challenge.

There were also a few things that weren't addressed due to limited information. What if the rover exceeds the world 
boundaries? Does the world wrap itself or is Google full of tinfoil hat wearing flat earthers? What if rovers obtain
the same area?

## License

    Copyright 2018 Kevin Woodland

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
