# Aquaculture
## 1.0 Introduction
The aquaculture monitoring system is a system that measures the conditions of aquaculture in environments such as shrimp farming tanks. The three parameters that are tracked are the temperature, TDS and pH. I was responsible for developing a mobile application to monitor the data captured by this system. 

The microcontroller used for this project was the ESP32. The sensors were programmed using Arduino IDE. The mobile application was created in Android Studio IDE using Java and Kotlin programming languages.The UI layouts were defined using XML. 
<br>
## 2.0 Application functions
The main functions of this application are listed below:

     • Presenting information about the three sensors used in the system  
     • Displaying real time sensor readings of the temperature, pressure and pH
     • Generating alerts if any of the parameters values were above/below a specified range
     • Presenting real time graphs showing the variation in the sensors readings within a 24 hour time period

<br>

## 3.0 Application overview
 
The figure below details how the Aquaculture Monitoring System application was structured and how users could navigate between activities using buttons.
<br>
<p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture-Monitoring-System/assets/124335793/da1175ed-649d-45a6-9f25-a20cb8f71a1e" width="800"> </p>
<p align="center"> Figure 1: Aquaculture monitoring system application activity flow </p>

 

## 4.0 Application activities and features
### 4.1 Splash screen
The first page of the Aquaculture monitoring system is a splash screen with a 5 second video animation. 
<br>
<p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture-Monitoring-System/assets/124335793/0e651eb7-69ea-4cac-9adf-04270493a6b9" width="200"> </p>
<p align="center"> Figure 2: Splash screen </p>

### 4.2 Slide screens
The next three pages were slide screens containing information about the three sensors used by the system. The user can navigate between these screen using back and next buttons or go straight to the real time viewer using the skip button.
<br>
<p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture-Monitoring-System/assets/124335793/b3ddfbd8-8b55-44d6-96fd-85acf66b1a05" width="650"> </p>
<p align="center"> Figure 3: Slide screens </p>

### 4.3 Real time viewer
This is the main activity page of this application. This page presented the real time sensor readings and buttons to access the real time graphs. Portrait and landscape layout qualifiers were added to this page.

<p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture-Monitoring-System/assets/124335793/726e7a68-4550-4bf0-9be7-0054d9628ab3" width="700"> </p>
<p align="center"> Figure 4: Main activity page (Portrait and landscape) </p>
<br><br>

The data captured by the sensors was sent to the Google Firebase real time database. The figure below shows how this data was saved in the real time database.
<p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture-Monitoring-System/assets/124335793/4cbe4d90-e234-4aee-b65c-42bc0c5a78aa" width="350"> </p>
<p align="center"> Figure 5:  Google Firebase database with the real time viewer data </p>

 
### 4.4 Real time graphs 
The real time graphs were generated using MP Android Chart Library. These graphs displayed how the sensor readings varied with time. In order to make it easier to analyze the graphs, portrait and landscape layout qualifiers  were added as shown below.These activities had a back button to navigate to the main activity page. Users could scroll horizontally and vertically and zoom in to view the graphs more clearly.
<p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture-Monitoring-System/assets/124335793/af8922eb-b678-425c-a441-c225a795da19" width="800"> </p>
<p align="center"> Figure 6: TDS graph activity page (Portrait and landscape)  </p><br><br>

The data points required for the graphs were stored in the Google Firebase database as shown below. The timestamp was generated using the internal RTC (Real Time Clock) of the ESP32 microcontroller.
<p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture-Monitoring-System/assets/124335793/e0a4cbf6-4024-4785-9911-3b47bfb255fd" width="750"> </p>
<p align="center"> Figure 7:  Google Firebase database with the real time graph data </p>

 

### 4.5 Alert dialogs

I added alert dialogs to create an alert if any of the three parameters went above a predefined nominal value.  
<p align="center"> 
<img src="https://github.com/DerickFernando51/Aquaculture-Monitoring-System/assets/124335793/8c389e26-1148-4f18-882a-f01e120dab8a" width="250"> </p>
<p align="center"> Figure 8:  pH Alert dialog </p>

  


 
 
 







