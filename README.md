# wikimusic

MusicWiki is an unofficial Last.fm app that contains information about different music
genres, albums, artists, and tracks listed under the genre. It is your own personal music encyclopedia!  
The application has been designed with Kotlin and XML.

## Features

1. The app covers music across all genres and gives vital information about them.
2. The app lists various albums, artists, and tracks pertaining to the selected genre.
3. On selecting an album, the user gets the description of the album, artist details, and the genres it is a part of.
4. On selecting an artist, the user gets a brief bio of the artist along with their play count and followers. The app also lists the artist's major songs and albums.
5. Overall, the application portrays powerful use of important concepts like coroutines, API requests using Retrofit, Image loading using Picasso, Recycler views, Fragments, Interactivity, Types of layouts, etc.

## Decisions 

The application uses last.fm APIs to get all the required data about the genres, artists, albums, and tracks.  

Kotlin has been used to design the app using Android Studio.  

The application follows Model View ViewModel architecture.  

Retrofit2, gson converter, Kotlin coroutines, and Picasso library dependencies have been used for features like making REST API calls, image downloading and displaying in the app, etc. 

Recycler views have been majorly used throughout the app to display lists of relevant data(albums, tracks, artists, genres). They are much better than traditional list views.  

The activity showing the genre details uses a tabbed layout to display the top albums, tracks, and artists of the respective genre.

The Main Activity uses a fragment to load the recycler view as it leads to faster performance of the app.  

Kotlin Coroutines have been extensively used throughout the application to make the required network requests.  

## Project Organisation and Structure

The project has the following packages:  
  *adapter*: This package holds all the adapter classes of all the Recycler Views used in the project.  
  *API*: This is the networking package. It contains the retrofit builder class and the retrofit interface to make the api calls.  
  *fragments*: This package contains all the fragments of the app. Fragments were used for the tabbed genre details activity and for loading recycler views.  
  *models*: all the model classes used as JSON models to make API requests are stored in this package.  
  *ViewModel*: View Models for all the activities are stored in this package. These models make the MVVM architecture possible.  
  
All the activities are present in the main musicwiki package with their XML files being in the res -> layout folder.  


## Working

HTTPS calls are made to get all the required data from last.fm platform. Retrofit library uses the RetroInstance class and the RetroService interface to make the HTTP operations. The JSON responses of various API calls are parsed according to the Model Data Classes defined in the project.  
After getting the data, it is passed to all the UI elements using the View Model Providers. Recycler view adapters are used to populate the recycler views.  
Mutable Live Data is used to update UI elements in real-time.  
Kindly note that the UI of the application is very basic due to time constraints. The main focus  was on the design and architecture of the application. The UI needs work to become beautiful and user-friendly.

Following is the drive link for the APK file of the project: https://drive.google.com/file/d/1HSXxwpnMl11cS8B-1xn3bzvSwp_daIB-/view?usp=sharing  

### Contact Details
Application 'musicwiki' created by:  
Anant Tyagi  
anant01tyagi@gmail.com  
https://www.linkedin.com/in/anant-tyagi-80430a1ba/  



