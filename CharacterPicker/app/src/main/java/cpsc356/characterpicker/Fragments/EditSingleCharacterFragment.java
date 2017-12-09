package cpsc356.characterpicker.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

import cpsc356.characterpicker.Models.CharacterCollection;
import cpsc356.characterpicker.Models.CharacterEntity;
import cpsc356.characterpicker.R;

/**
 * Created by matthewshiroma on 12/8/17.
 *  This displays the edit character screen, allowing the user to edit the character
 */

public class EditSingleCharacterFragment extends Fragment {

    public static final String CHARACTER_ID_KEY = "character_id";
    public static final String CHARACTER_NAME_KEY = "character_name";
    public static final String CHARACTER_AGE_KEY = "character_age";
    public static final String CHARACTER_DESC_KEY = "character_desc";
    public static final String CHARACTER_PIC_ID = "character_pic_id";
    public static final String CHARACTER_SEX_PIC_ID = "character_sex_pic_id";

    private ImageView editCharacterProfile;
    private EditText editCharacterName;
    private EditText editCharacterAge;
    private EditText editCharacterDescription;
    private Spinner editCharacterSex;

    private CharacterEntity currentCharacter;

    // We first get the character data
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String currentCharacterID = getArguments().getString(CHARACTER_ID_KEY);
        currentCharacter = CharacterCollection.GetInstance().getCharacterById(currentCharacterID);
    }

    // We then prepare the view with all of the necessary data and return it
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View currView = inflater.inflate(R.layout.fragment_view_character, container, false);

        // First step is to initialize all of the private variables
        editCharacterProfile = (ImageView) currView.findViewById(R.id.fragment_profileImageView);
        editCharacterName = (EditText) currView.findViewById(R.id.fragment_nameTextView);
        editCharacterAge = (EditText) currView.findViewById(R.id.fragment_ageTextView);
        editCharacterSex = (Spinner) currView.findViewById(R.id.sex_ImageView);
        editCharacterDescription = (EditText) currView.findViewById(R.id.fragment_descTextView);

        // Then, we get the data from the passed in arguments and put them into the Widgets
        int profilePicId = getArguments().getInt(CHARACTER_PIC_ID);
        String sexValue = currentCharacter.getSexString();
        String name = getArguments().getString(CHARACTER_NAME_KEY);
        String desc = getArguments().getString(CHARACTER_DESC_KEY);
        int age = getArguments().getInt(CHARACTER_AGE_KEY);

        editCharacterProfile.setImageResource(profilePicId);
        //TODO: IMPLEMENT SPINNER
        editCharacterName.setText(name);
        editCharacterDescription.setText(desc);
        editCharacterAge.setText(String.format(Locale.US,"%d", age));

       // TODO: IMPLEMENT LISTENERS

        return currView;
    }

}