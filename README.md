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

## Running the Chatbot

Once you have completed the configuration steps, you can run the customer support chatbot.

```sh
# Navigate to the project directory
cd path/to/customer-support-chatbot

# Run the chatbot
# Add any additional commands or instructions here
