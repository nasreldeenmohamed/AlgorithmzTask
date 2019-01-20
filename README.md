# AlgorithmzTask
Top Rated Movies via TMDB 

Project structure:
-------------------
the project contains 2 modules:
- 2 activities (show top movies list, movie details)
- one view model class
- 2 data repositories class (genres repo & top rated movies)
- retrofit repository singleton class for calling APIs and get data from server

how it works
---------------
1- view model calls repos to get data, 2 lists of data which are top rated movies list and genres list, then each movie's list will be mapped throught their IDs
2- the genres repository have to deliver the view model with a HashMap not List, so I converted the format of the data in the GenresRepository
3- the MainActivity only shows the list of movies that is returned from the viewModel
4- on item clicked, the "movie" object is passed to the next activity as extra, the Movie class is implementing Parcelable class
5- the MovieDetailsActivity shows the movie info only

Technologies Used:
---------------------
- MVVM in presentation layer
- LiveData to observe web service responses
- Retrofit for web services connection
- DataBinding
- Programming Language: Java (except the second activity class)
- CoordinatorLayout / ConstraintLayout are used in both activities
