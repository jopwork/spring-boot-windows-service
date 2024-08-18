@REM Install the service.
@REM The %~dp0 is some batch file magic that expands to the batch file's path
@REM Update the Java Home directory accordingly

%~dp0prunsrv.exe //IS//HelloService ^
    --Description "HelloService" ^
    --Startup manual ^
    --ServiceUser "LocalSystem" ^
    --JavaHome "C:\Program Files\Amazon Corretto\jdk17.0.12_7" ^
    --Classpath "%~dp0webapp-0.0.1-SNAPSHOT.jar" ^
    --StartMode jvm ^
    --StartClass org.springframework.boot.loader.launch.JarLauncher ^
    ++StartParams start ^
    --StopMode jvm ^
    --StopClass org.springframework.boot.loader.launch.JarLauncher ^
    ++StopParams stop ^
    --StopTimeout 60 ^
    --LogPath "%~dp0log" ^
    --LogLevel Debug ^
    --StdOutput auto ^
    --StdError auto
