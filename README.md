#Weather website — Instructions
Requirements
Create a website which will return current weather data from OpenWeatherMap.org, based on a city chosen by the user, which should support:

London
Hong Kong

the user should be able to input their choice of city via a standard HTML form & receive results showing:

today’s date
the city name
overall description of the weather (e.g. "Light rain", "Clear sky", etc.)
temperature in Fahrenheit and Celsius
sunrise and sunset times in 12 hour format (e.g. 9:35am; 11:47pm)

the styling / layout of the website itself is not a priority — please feel free to use plain HTML with no styling

#Implementation details

the backend of the application should use core Java SE, EE and any 3rd party libraries that you deem relevant

the project should be able to be compiled on a machine with Maven 3.3 and Java SE8. Please give full instructions for set-up, as needed

the website should able to be run on a port of ‘localhost’, via some embedded application server (e.g. Jetty or similar)
Discussion topics
Production quality code is much more important than feature completion. Please add a "To do" section as part of the repo's README.md file, which covers off:

any elements described above that you didn't manage to implement (if you run out of time)
any other considerations that would stop this code going into a Production environment

you should be able to discuss your code, including your design choices and their pros/cons

#Instruction to run the current project locally

First of all checkout the code from current repository.

Assuming that you have installed on your machine a JVM 1.8 and Maven 3.3.

In order to run the app locally you can run from command line the following command "mvn spring-boot:run" then go to your browser and open the following URL "http://localhost:8080/". Next according the requirements type a city name and hit "View Weather" button. The result will be displayed below.

#Improvements

Here can be done a lot of improvements starting from the layout and ending with error handling and fuzzy search through the list of cities.
