# Cryptography with JAVA #

> For More details, Visit https://jenkov.com/tutorials/java-cryptography/index.html

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

## Asymmetric encryption ##
private key for encryption. public key for decryption

Algorithm: 
* Diffe - Hellman, 
* RSA, 
* ECC

> Don't use Asymmetric encryption to encrypt large block of data

## Mac ##
* MAC is short for **Message Authentication Code**. 
* A MAC is similar to a message digest, but uses an additional key to encrypt the message digest. 
* Only by having both the original data and the key can you verify the MAC. 
* Thus, a MAC is a more secure way to guard a block of data from modification than a message digest

Algorithm:
* HmacSHA224
*  HmacSHA256
*  HmacSHA384
*  HmacSHA512
*  HmacSHA512/224
*  HmacSHA512/256
*  HmacSHA3-224
*  HmacSHA3-256
*  HmacSHA3-384
*  HmacSHA3-512

## KeyStore ##
* The Java KeyStore is a database that can contain keys. A Java KeyStore is represented by the KeyStore (java.security.KeyStore) class. 
* A KeyStore can hold the following types of keys:
  * Private keys 
  * Public keys + certificates
  * Secret keys
>Private and public keys are used in asymmetric encryption. 

> A public key can have an associated certificate.
>> A certificate is a document that verifies the identity of the person, organization or device claiming to own the public key. A certificate is typically digitally signed by the verifying party as proof.

> Secret keys are used in symmetric encryption

## Signature ##
The Signature (java.security.Signature) class is used to digital sign data. When data is signed a digital signature is created from that data. The signature is thus separate from the data.

A digital signature is created by creating a message digest (hash) from the data, and encrypting that message digest with the private key of the device, person or organization that is to sign the data. The encrypted message digest is called a digital signature.
