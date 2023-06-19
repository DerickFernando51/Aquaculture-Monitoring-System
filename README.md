# Aquaculture
The aquaculture monitoring system is a system that measures the conditions of aquaculture in environments such as shrimp farming tanks. The three parameters that are tracked are the temperature, TDS and pH. I was responsible for developing a mobile application to monitor the data captured by this system. 

The mobile application was created in Android Studio IDE using Java programming language and XML.  The main functions of this application are listed below:

     • Presenting information about the three sensors used in the system (Using slide screens)
     • Displaying real time sensor readings of the temperature, pressure and pH
     • Generating alerts if any of the parameters values were above/below a specified range
     • Presenting real time graphs showing the variation in the sensors readings within a 24 hour time period
<br>
Figures 1 to 6 show the layout of the activities of this application.<br>

<br>
 <p align="center"> 
 <img src="https://github.com/DerickFernando51/Aquaculture/assets/124335793/8bfe726e-f0c8-4ff6-944f-2a8da009352d" width="675"> </p>
 
 <br><br>
 <p align="center"> 
 <img src="https://github.com/DerickFernando51/Aquaculture/assets/124335793/d2489b33-9b47-41a6-a136-11dbcc5438bb" width="675"> </p>
 

 
  <br> <br>
In order to make it easier to analyze the graphs, landscape layout qualifiers were added to the main and graph activity pages as shown in figure 7 and 8.
 <br>
 <p align="center"> 
 <img src="https://github.com/DerickFernando51/Aquaculture/assets/124335793/4cec7040-bf31-4288-ae2a-cc33d702d263" width="550"> </p>
  
  <br><br>
 <p align="center"> 
 <img src="https://github.com/DerickFernando51/Aquaculture/assets/124335793/3d50e2fe-0644-4840-93fa-ccd63d5e98f9" width="550"> </p>
<br>
 

 
 <br>
The graphs were generated using MP Android Chart Library. The sensors readings were saved in the Google Firebase database using Arduino IDE. 
RTC



I also added alert dialogs to create an alert if any of the three parameters went above a predefined nominal value. This is illustrated in figure 9
<br>
<p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture/assets/124335793/8cfc5d36-708e-49f6-855b-1d66ff9613f4" width="225"> </p>
  <br> <br> <br>

 <p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture/assets/124335793/338f079f-0aae-48f1-95be-61f3a963f501" width="750"> </p>
<br>

Figure 10 details how the Aquaculture application was structured and how users could navigate between activities using buttons.









