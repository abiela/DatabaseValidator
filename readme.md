# Associative Graph Data Structure
This project contains an [Associative Graph Data Structure](home.agh.edu.pl/~horzyk/lectures/aas/SSS-AGDS.pdf) algorithm implementation written in **Java** to present innovative approach to database structure.

The algorithm was invented by 👨‍💻 [Adrian Horzyk](https://www.linkedin.com/in/adrian-horzyk-30658844/?originalSubdomain=pl), Assistant Professor from AGH UST in Cracow, Poland.

AGDS library and its' visualization is presented on top of **Android** application.

⚠️ **DISCLAIMER:** Implementation was completed as a part of 🎓 classes during my 4th year of studies, in 2016. I haven't changed any line of code since that time to have a strong reference point for my coding skills.

## 📱 How does it work?

### Android application

**Android application with AGDS algorithm is performed on well-known [Iris dataset](https://archive.ics.uci.edu/ml/datasets/iris).**

![application gif](../readme/application.gif)

### Available features

🕶️ Sorting dataset by selected attribute

🕶️ Find min / max value in dataset for selected attribute

🕶️ Find values in dataset with selected range for selected attribute

🕶️ Find most / least similar value in dataset to provided new Iris datapoint

🕶️ Find all values in dataset above / below selected similarity percentage

## 📚 AGDS library

You can find a quick start with AGDS library.

### Creating a new library instance

```java
AGDS agds = new AGDS();
```

### Launching AGDS structure based on Iris dataset

``` java
agds.launchAGDSStructureFromFile(context.getResources().openRawResource(R.raw.iris_data));
```

### Sorting by provided attribute

```java
List<RecordNode> maxRecordsList = agds.sortByAttribute(attributeName, Sort.DESCENDING);
```

## 💾 Installing

In order to start working with the project, just `git clone` it. You'll get fully working Android project that is ready to be launched.

You can also build your own application on top of AGDS library. You can find it under `app/libs` directory.

## 🤜🤛🏼 Contribution

Would you like to take part in the project and contribute? 🚧 Feel free to create a pull request, I would be more than happy to add it to my project and collaborate!
