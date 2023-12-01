package CryptoApp.cryptoApp.controller;

import CryptoApp.cryptoApp.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coin")
public class CoinController {

    @Autowired
    private CoinRepository coinRepository;

    @PostMapping()
    public ResponseEntity post(@RequestBody Coin coin) {

        try {
            coin.set
        }catch(Exceptionxe error) {

        }
    }



}
