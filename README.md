# Customer Support Chatbot

This repository contains a customer support chatbot that utilizes Google Cloud services. Follow the steps below to set up and run the program.

## Prerequisites

1. **Google Cloud Account:**
   - Create a Google Cloud account if you don't have one: [Google Cloud Console](https://console.cloud.google.com/).

2. **Enable API Services:**
   - Enable the necessary API services for the chatbot to function.

3. **Download and Install Google Cloud SDK:**
   - Follow the instructions to download and install the Google Cloud SDK: [Install SDK](https://cloud.google.com/sdk/docs/install-sdk).

## Configuration

1. **Set Default Application Credentials:**
   - Open a terminal and execute the following command to authenticate your application:
     ```sh
     gcloud auth application-default login
     ```

2. **Set Default Project:**
   - Set your default project using the following command:
     ```sh
     gcloud config set project <your-project-name>
     ```
     Replace `<your-project-name>` with the name of your Google Cloud project.
# Make sure to 
Change all the paths to the appropriate ones,they will be highlighted with the TODO command


## Running the program

Once you have completed the configuration steps, you can run the customer support app.

```sh
# Navigate to the project directory
cd path/to/project
```
# Run
```sh
mvn package
```
```sh
java -jar target/project-1.0-SNAPSHOT.jar 
```


# Repository Structure

The repository has the following structure:  
my-project  
│  
├── src  
│ ├── main  
│ ├── java/com/freddo # Application code  
│ └── resources # Resource files  
│  
├── pom.xml # Maven configuration file  
├── README.md # Project description file (Markdown)  
└── LICENSE # License file  

# Data Structures and Algorithms  

## Data Structures

 **Lists:** Used for storing and managing a sequence of elements.
## Algorithms

 **Linear Search**
