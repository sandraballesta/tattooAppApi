<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use App\Models\Style;


class StyleController extends Controller
{
    //Get all styles
    public function getStyles(){
            $styles = DB::table('style')
                ->select('*')
                ->get();

            return response()->json(['styles' => $styles], 200);
        }

}
