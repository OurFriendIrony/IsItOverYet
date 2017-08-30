package uk.co.ourfriendirony.isitoveryet.general;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

public class IntentGenerator {
    private static String APP_NAME = "Is It Over Yet?";
    public static final String CONTACT_EMAIL = "ourfriendirony@gmail.com";

    @NonNull
    public static Intent getWebPageIntent(String webAddress) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(webAddress));
        return intent;
    }

    public static Intent getContactEmailIntent() {
        String emailToAddress = CONTACT_EMAIL;
        String emailSubject = "[" + APP_NAME + "] I've got this to say about your app...";
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{emailToAddress});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, emailSubject);

        return emailIntent;
    }
}
