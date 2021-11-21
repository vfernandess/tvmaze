# tvmaze

# TvMaze

TvMaze app the following technologies were used:

- MVVM
- Clean Architecture
- Dependency Injection
- SOLID
- Data Binding
- LiveData
- RxJava
- RxAndroid
- Repository
- Modularization

# How it works

Basically using the repository pattern in conjunction with RX to get the information 
from the right place (this project only supports network calls), after this the information 
is passed to an UseCase which transforms to an DTO or applies some behavior in that info until 
the new information arrive on ViewModel which convert the info to a State Pattern which the
view listen for changes through the LiveData and then repass to DataBinding framework 
and finally the info is printed on the screen.

The below image shows how this is made for better understanding:

![how it works](https://raw.githubusercontent.com/vfernandess/tvmaze/main/base.png)

# Modularization

The modularization was created for building performance time and to prevent cyclic dependencies
between modules. The following rules must be applied:

1. When creating a new module it must have two sub-modules: public and impl
2. Public and Impl modules can only depend of other Public Modules. Except for the "app" module 
   because it depends of all modules, it will act like a "glue" to unite all the modules.
   
The public module exposes to other modules only what is necessary to the other module work 
like: images, layout or even some data classes in common.

The impl(ementation) does not exposes nothing, it's build only for the feature work. Some classes 
goes on this module like: DI, Views(Fragments or Activities), ViewModels, and other classes
that belong to a feature.

The Image below represents de modularization process

![modularization](https://raw.githubusercontent.com/vfernandess/tvmaze/main/modularization.png)

The project has another secondary modules
* core: contains som utility classes, extensions, network settings.
* design-system: contains styles, images and another resources in common for all project, 
  in the future it will help on the theming.
