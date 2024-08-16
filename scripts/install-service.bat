@REM Install the service.
@REM The %~dp0 is some batch file magic that expands to the batch file's path
@REM Update the Java Home directory accordingly

%~dp0prunsrv.exe //IS//HelloService ^
    --Description "HelloService" ^
    --Startup manual ^
    --Classpath "%~dp0webapp-0.0.1-SNAPSHOT.jar" ^
    --StartMode jvm ^
    --StartClass org.springframework.boot.loader.launch.JarLauncher ^
    --StopMode jvm ^
    --StopClass org.springframework.boot.loader.launch.JarLauncher ^
    --StopParams stop ^
    --ServiceUser "LocalSystem" ^
    --LogPath "%~dp0log" ^
    --LogLevel Debug ^
    --JavaHome "C:\Program Files\Amazon Corretto\jdk17.0.12_7" ^
    --StdOutput auto ^
    --StdError auto
