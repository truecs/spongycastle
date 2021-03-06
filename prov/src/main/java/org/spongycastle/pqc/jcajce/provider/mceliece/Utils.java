package org.spongycastle.pqc.jcajce.provider.mceliece;

import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

class Utils
{
    static AlgorithmIdentifier getDigAlgId(String digestName)
    {
        if (digestName.equals("SHA-1"))
        {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
        }
        if (digestName.equals("SHA-224"))
        {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, DERNull.INSTANCE);
        }
        if (digestName.equals("SHA-256"))
        {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, DERNull.INSTANCE);
        }
        if (digestName.equals("SHA-384"))
        {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, DERNull.INSTANCE);
        }
        if (digestName.equals("SHA-512"))
        {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, DERNull.INSTANCE);
        }

        throw new IllegalArgumentException("unrecognised digest algorithm: " + digestName);
    }

    static Digest getDigest(AlgorithmIdentifier digest)
    {
        if (digest.getAlgorithm().equals(OIWObjectIdentifiers.idSHA1))
        {
            return new SHA1Digest();
        }
        if (digest.getAlgorithm().equals(NISTObjectIdentifiers.id_sha224))
        {
            return new SHA224Digest();
        }
        if (digest.getAlgorithm().equals(NISTObjectIdentifiers.id_sha256))
        {
            return new SHA256Digest();
        }
        if (digest.getAlgorithm().equals(NISTObjectIdentifiers.id_sha384))
        {
            return new SHA384Digest();
        }
        if (digest.getAlgorithm().equals(NISTObjectIdentifiers.id_sha512))
        {
            return new SHA512Digest();
        }
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + digest.getAlgorithm());
    }
}
