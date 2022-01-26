package  fr.dosi.etron.security;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET="ismail@fssm.uca";
    public static final long EXPIRATION=86400000;
    public static final String HEADER_PREFIX="Bearer ";
}