#Cryptography with JAVA #

**what does it solve?**
confidentiality, integrity, authenticity

Concepts in modern cryptography
1. symmetric encryption
2. Asymmetric encryption
3. Hashing

**JDK APi - JCA/JCE api**

## Providers ##

- SunJce (default available in jdk)
- Bouncy castle(third party provider)

**How to plug in providers?**
1. `Security.addProvider(new SpecificProviders());` -- (extends java.security.Provider class)

2. register in java.security file (/jre/lib/java.security) and place provider jar in lib/ext

**The core classes and interfaces of these packages are:**

	Provider
	SecureRandom
	Cipher
	MessageDigest
	Signature
	Mac
	AlgorithmParameters
	AlgorithmParameterGenerator
	KeyFactory
	SecretKeyFactory
	KeyPairGenerator
	KeyGenerator
	KeyAgreement
	KeyStore
	CertificateFactory
	CertPathBuilder
	CertPathValidator
	CertStore

## Hashing ##
taking byte of streams and converting it to a byte array or value of fixed size (digest)

**Properties of hashing:**
- one way
- deterministic
- Fixed size
- Pseudo random

**Algorithms**: 
* md5 - 128 bits(hacked), 
* sha1 - 160 bits, 
* sha256 - 256 bits

**Example** - store password as hash in db

## Symmetric encryption ##
using a single key to encrypt and decrypt messages
encrypt message is called cipher

Algorithm: 
* DES (hacked), 
* AES

Example - crypto wallet

##Asymmetric encryption ##
private key for encryption. public key for decryption

Algorithm: 
* Diffe - Hellman, 
* RSA, 
* ECC

> Don't use Asymmetric encryption to encrypt large block of data

