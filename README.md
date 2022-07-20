# DB Switcher

## Build and run (via command line)

To run application with PostgreSQL db follow next steps:
### Step #1 Run PostgreSQL
```
docker-compose up -d postgres
```
### Step #2 Run application with profile 'dev'
```
./gradlew clean bootRun -PenvId=dev
```

To run application with H2 db follow next steps:
### Run application with profile 'local'
```
./gradlew clean bootRun -PenvId=local
```

#### [Attention] When no selected env id then local env id is used

## Build and run (via command line)

### Step 1. Edit configuration
### Step 2. Add Gradle task
### Step 3. Use related gradle command to run certain launch variant
