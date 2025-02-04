## 🔧 Prerequisites:


* **[Node.js](https://nodejs.org/)** (v14 or higher)
* **[Docker](https://www.docker.com/get-started)** (for containerizing the app)
* **[Git](https://git-scm.com/downloads)** (to clone the repository)


## 📝 Setup .env File:


1. Navigate to the `backend` directory:
```bash
cd backend
```
2. Create a `.env` file and add the following content (modify the values as needed):
```env
MONGO_URI=mongodb+srv://your_username:your_password@cluster0.jrrwp.mongodb.net/  # Use your MongoDB URI
PORT=8000  
SECRET_KEY=your_jwt_secret_key  # Choose a strong secret key for JWT
CLOUD_NAME=dvta1s9ru  # Replace with your Cloudinary cloud name
API_KEY=your_cloudinary_api_key  # Your Cloudinary API Key
API_SECRET=your_cloudinary_api_secret  # Your Cloudinary API Secret
```
> # Replace the following values with your own. Do not use these provided credentials as they belong to someone else.
  # If you use the same credentials, all data will be stored in the owner's account, not yours.

### Clone the Repository

```bash
git clone https://github.com/pundir8372/Job-Portal.git
```

## 🏗️ Build and Run the Application"

Follow these steps to build and run the application:

1. Build & Run the Containers:

```bash
cd Job-Portal
```
```bash
docker-compose up -d --build
```

2. Access the application in your browser:

```
http://localhost:5173
```
---

## 🛠️ Getting Started

Follow these simple steps to get the project up and running on your local Host using docker.

```bash
git clone https://github.com/pundir8372/Job-Portal.git
```

```bash
cd Job-Portal
```
## Create a Docker network:

```bash
docker network create three-tier
```

## 🛠️ Building the Frontend

```bash
cd frontend
```

```bash
docker build -t frontend-image .
```

### Run the Frontend container:

```bash
docker run -d --network=three-tier  -p 5173:5173 --name frontend-container frontend-image
```
#### The frontend will now be accessible on port 5173.


### Run the MongoDB Container:

```bash
docker run -d --network three-tier -p 27017:27017 --name mongodb mongo:latest
```
---

## 🛠️ Building the Backend

```bash
cd backend
```

### Build the Backend image:

```bash
docker build -t backend-image .
```

### Run the Backend container:

```bash
docker run -d --network=three-tier  -p 8000:8000 --env-file .env backend-image

```
#### This will build and run the backend container, exposing the backendAPI on port 8000.

`Backend API: http://localhost:8000`

### To Verify the conncetion between backend and databse:
```bash
docker-compose logs -f
```

### Once the backend and frontend containers are running, you can access the application in your browser:

`Frontend: http://localhost:5173`


You can now interact with the Job-Portal and start applying for your dream job!

---


## 🔮 Future Plans


This project is evolving, and here are a few exciting things on the horizon:

* [ ] **CI/CD Pipelines:** Implement Continuous Integration and Continuous Deployment pipelines to automate testing and deployment.
* [ ] **Kubernetes (K8s):** Add Kubernetes manifests for container orchestration to deploy the app on cloud platforms like AWS, GCP, or Azure.
* **Stay tuned for updates as we continue to improve and expand this project!**

---

## 📜 License


This project is licensed under the MIT License. See the LICENSE file for more details.
