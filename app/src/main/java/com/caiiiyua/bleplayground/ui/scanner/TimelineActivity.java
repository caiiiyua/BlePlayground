package com.caiiiyua.bleplayground.ui.scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.caiiiyua.bleplayground.R;
import com.caiiiyua.bleplayground.data.local.Timeline;
import com.caiiiyua.bleplayground.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimelineActivity extends BaseActivity implements TimelineUi {

    private static final int PERMISSION_EXTERNAL_STORAGE = 1;
    private static final int PERMISSION_INTERNET = 2;

    @Inject
    TimelinePresenter mPresenter;

    TimelineAdapter mAdapter;

    @BindView(R.id.timeline_label)
    TextView timelineLabel;
    @BindView(R.id.timeline_list)
    RecyclerView timelineList;
    @BindView(R.id.root_view)
    View rootView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);
        toolbar.setTitle(R.string.timeline);
        setSupportActionBar(toolbar);

        mAdapter = new TimelineAdapter(this);
        timelineList.setAdapter(mAdapter);
        timelineList.setLayoutManager(new LinearLayoutManager(this));
        mPresenter.attachUi(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachUi();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        MenuItem share = menu.findItem(R.id.action_share);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @Override public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                                     int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), getString(R.string.no_external_storage_permission_tips),
                            Toast.LENGTH_LONG).show();
                }
                break;
            }
            case PERMISSION_INTERNET: {
                if (grantResults.length > 0
                        && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), getString(R.string.no_internet_permission_tips),
                            Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    @Override
    public void showTimeline(List<Timeline> timelines) {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyTimeline() {

    }

    @Override
    public void showInvalidUpdate(String title) {
        Snackbar.make(rootView, getString(R.string.invalidUpdate, title), Snackbar.LENGTH_LONG).show();
    }

    public static Intent getStartTimelineActivityIntent(Context context) {
        Intent i = new Intent(context, TimelineActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return i;
    }

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private boolean checkPermission(final Activity activity, final String permission, final int code) {
        if (ContextCompat.checkSelfPermission(activity, permission)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{permission}, code);
            return false;
        }
        return true;
    }
}
