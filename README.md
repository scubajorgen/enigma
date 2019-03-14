# enigma
## Enigma simulation
This program simulates the Enigma M3 and M4. It was created to study the famous encryption/decryption machine used during WWII.

## Usage

        enigma=new EnigmaM3();
        enigma.setWalzen("I II III");
        enigma.setUmkehrWalze("UKW B");
        enigma.setSteckers("bq cr di ej kw mt os px uz gh");
        enigma.setRingStellungen("1 1 1");
        enigma.setGrundStellungen("Q D U");

        System.out.println("Encoded: "+enigma.encodeDecode("Some text"));

Output: 
Encoded: RGBOHSNP

Note: RingStellungen and Grundstellungen can be entered as 01-26, 1-26, A-Z or a-z
