@echo off
set /p desc="Enter commit description: "
IF NOT [%desc] == [] goto skip
set desc=autopush.bat commit
:skip
git add .
git commit -m "[%desc]"
git push origin master