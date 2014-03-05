$ok = 0
$nok = 0
$err = 0
$i = 0
$url = 'http://10.0.0.50:8080/global/lm'

while($i -lt 6){
    $request = Invoke-WebRequest -Uri $url

    if($request.StatusCode -eq "200"){
        Write-url "$url  - ok"
        $ok ++
        $err = 0
    }
    else{
        Write-url "$url  - error"
        $nok ++
        $err ++
    }

    if($err -eq 3){
        Write-url "$url  - down"

        Write-url "Stopping Service railo-iqweb"
        Stop-Service railo-iqweb

        Write-url "Waiting 10 seconds to start railo-iqweb"
        Start-Sleep -s 10

        Write-url "Starting Service railo-iqweb"
        Start-Service railo-iqweb

        Write-url "$url  - down"

        Write-url "Waiting 30 seconds before resuming check"

        Start-Sleep -s 30

    }else{ 
        Start-Sleep -s 10
    }

    $i++
}
 
Write-url “Loop complete”
Write-url “ok: $ok”
Write-url “nok: $nok”