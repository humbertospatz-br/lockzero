@echo off
REM ============================================
REM  LockZero - Build Script
REM  Seleciona e prepara o icone para compilacao
REM ============================================

REM Muda para o diretorio do script
cd /d "%~dp0"

:menu
cls
echo.
echo ========================================
echo      LockZero - Build Script
echo ========================================
echo.
echo   [F] Preparar build FREE
echo   [P] Preparar build PREMIUM
echo   [X] Sair
echo.
set /p opcao="Escolha a opcao: "

if /i "%opcao%"=="F" goto build_free
if /i "%opcao%"=="P" goto build_premium
if /i "%opcao%"=="X" goto fim
goto menu

:build_free
echo.
echo Aplicando icone FREE...
copy /Y "Files\ic_lockzero.png" "Objects\res\drawable\icon.png" >nul
if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo   [OK] Icone FREE aplicado!
    echo ========================================
    echo.
    echo   No B4A selecione:
    echo   Build Configuration = free
    echo.
    echo   O #IF f sera ativado automaticamente
    echo ========================================
) else (
    echo [ERRO] Falha ao copiar o icone!
)
goto fim

:build_premium
echo.
echo Aplicando icone PREMIUM...
copy /Y "Files\ic_lockzero_premium.png" "Objects\res\drawable\icon.png" >nul
if %ERRORLEVEL% EQU 0 (
    echo.
    echo ========================================
    echo   [OK] Icone PREMIUM aplicado!
    echo ========================================
    echo.
    echo   No B4A selecione:
    echo   Build Configuration = premium
    echo.
    echo   O #IF P sera ativado automaticamente
    echo ========================================
) else (
    echo [ERRO] Falha ao copiar o icone!
)
goto fim

:fim
echo.
pause
