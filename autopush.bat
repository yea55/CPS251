@echo off
set /p d="Enter commit description: "
IF NOT [!d!] == [] goto skip
set d="autopush.bat commit"
:skip
git add .
git commit -m !d!
git push origin master